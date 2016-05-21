package hu.inf.unideb.dungeonraider.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hu.inf.unideb.dungeonraider.domain.ItemType;
import hu.inf.unideb.dungeonraider.domain.PlayersCharacter;
import hu.inf.unideb.dungeonraider.service.ConflictingEntityException;
import hu.inf.unideb.dungeonraider.service.MissingEntityException;
import hu.inf.unideb.dungeonraider.service.PlayerService;

/**
 * Controller of character operations.
 * 
 * @author FV
 *
 */

@Controller("characterController")
@RequestMapping("/characters")
@SessionAttributes(types = PlayersCharacter.class)
// @SessionAttributes(types = ShopForm.class)
public class CharacterController extends AbstractController {

	/** SLF4J Logger */
	private final Logger log = LoggerFactory.getLogger(CharacterController.class);

	@Autowired
	private PlayerService playerService;

	/**
	 * Create request handler.
	 * 
	 * @param model the model
	 * @return the view name
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET, produces = "text/html")
	public String create(Model model) {

		CharacterForm form = new CharacterForm();
		form.setStrength(0);
		form.setDexterity(0);
		form.setQuickness(0);
		form.setHealth(0);
		model.addAttribute("form", form);
		log.info("Character creatation continued");
		return "characters/create";

	}

	/**
	 * Character create submission
	 * 
	 * @param model the model
	 * @param form the character form
	 * @param errors the errors
	 * @return the view name
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "text/html")
	public String createSubmit(Model model, CharacterForm form, Errors errors, RedirectAttributes redirectAttrs) {

		log.info("Try to process character create subbmision");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "validation.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "validation.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "strength", "validation.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dexterity", "validation.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "health", "validation.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quickness", "validation.required");

		if (errors.hasErrors()) {
			log.warn("Empty field in the character creation");
			return "characters/create";
		}

		if (form.getHealth() + form.getDexterity() + form.getQuickness() + form.getStrength() > 10) {
			addErrorMsg(redirectAttrs, "create.wrongValueDivision");
			log.warn("Invalid division of stat points!");
			return "characters/create";
		}
		try {
			playerService.createNewCharacter(form.getHealth(), form.getDexterity(), form.getStrength(), form.getQuickness(), form.getName(),
					form.getPassword());
		} catch (ConflictingEntityException conflictingEntityException) {
			log.warn("Conflicting value in character creation");
			for (String field : conflictingEntityException.getPropertyNames()) {
				errors.rejectValue(field, "create.conflictingValue");
			}

		}

		PlayersCharacter pc = playerService.findByNameAndPassword(form.getName(), form.getPassword());
		if (pc == null) {
			log.error("Internal problem occured while handled character create submision.");
			addErrorMsg(redirectAttrs, "error.notFoundCharacter");
			return "redirect:/500.html";
		}

		log.info("Character successfully created");
		addSuccessMsg(redirectAttrs, "success.characterCreate");

		return "redirect:/characters/edit?id=" + pc.getId();

	}

	/**
	 * Edit view handler of characters.
	 * 
	 * @param model the model
	 * @param id the saved character id
	 * @return the view name
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET, produces = "text/html")
	public String edit(Model model, @RequestParam("id") int id) {
		log.info("Handling character edit view id= " + id);
		PlayersCharacter pc = playerService.findById(id);
		if (pc == null) {
			log.error("Internal problem occured while handled chracter submision.");
			return "redirect:/500.html";
		}
		CharacterForm form = new CharacterForm();
		form.setName(pc.getName());
		// form.setActualArmor(pc.getActualArmor());
		// form.setActualShield(pc.getActualShield());
		// form.setActualWeapon(pc.getActualWeapon());
		form.setRace(pc.getRace());
		model.addAttribute("form", pc);
		model.addAttribute("itemsWeights", playerService.calculateItemsWeightByCharacter(pc.getId()));
		model.addAttribute("playerCharacter", pc);

		return "characters/edit";

	}

	/**
	 * Handling itemg and equipping submission.
	 * 
	 * @param model the model
	 * @param id the chracter id
	 * @param type the item type
	 * @param prototype the players character prototype
	 * @param redirectAttrs the redirect attributes
	 * @return the view name
	 */
	@RequestMapping(value = "/equip", method = RequestMethod.GET, produces = "text/html")
	public String equipItem(Model model, @RequestParam("id") int id, @RequestParam("type") ItemType type, PlayersCharacter prototype,
			RedirectAttributes redirectAttrs) {
		PlayersCharacter pc = playerService.findById(prototype.getId());
		if (pc == null) {
			log.error("Internal problem occured while handled characters item equip submision. Character not found.");
			addErrorMsg(redirectAttrs, "error.notFoundCharacter");
			return "redirect:/500.html";
		}

		try {
			playerService.equipItem(type, id, prototype.getId());
		} catch (MissingEntityException ex) {

			log.error("Internal problem occured while handled characters item equipping.");
			addErrorMsg(redirectAttrs, "error.cantEquiped");
			return "redirect:/characters/edit?id=" + pc.getId();
		}
		addSuccessMsg(redirectAttrs, "success.itemEquipped");

		model.addAttribute("form", pc);
		return "redirect:/characters/edit?id=" + pc.getId();
		// return "shop/items";

	}

	@RequestMapping(value = "/drop", method = RequestMethod.GET, produces = "text/html")
	public String dropItem(Model model, @RequestParam("id") int id, @RequestParam("type") ItemType type, PlayersCharacter prototype,
			RedirectAttributes redirectAttrs) {
		PlayersCharacter pc = playerService.findById(prototype.getId());
		if (pc == null) {
			log.error("Internal problem occured while handled characters item drop submision. Character not found.");
			addErrorMsg(redirectAttrs, "error.notFoundCharacter");
			return "redirect:/500.html";
		}

		try {
			playerService.unEquipItem(type, id, prototype.getId());
		} catch (MissingEntityException ex) {

			log.error("Internal problem occured while handled characters item unEquipping.");
			addErrorMsg(redirectAttrs, "error.cantEquiped");
			return "redirect:/characters/edit?id=" + pc.getId();
		}
		addSuccessMsg(redirectAttrs, "success.itemUnEquipped");
		try {
			playerService.dropItem(type, id, prototype.getId());
		} catch (MissingEntityException ex) {

			log.error("Internal problem occured while handled characters item unEquipping.");
			addErrorMsg(redirectAttrs, "error.cantEquiped");
			return "redirect:/characters/edit?id=" + pc.getId();
		}
		addSuccessMsg(redirectAttrs, "success.itemUnEquipped");

		model.addAttribute("form", pc);
		return "redirect:/characters/edit?id=" + pc.getId();
		// return "shop/items";

	}

	// FIXME: Unused
	@RequestMapping(value = "/edit", method = RequestMethod.POST, produces = "text/html")
	public String editSubmit(Model model, CharacterForm form) {

		model.addAttribute("form", new CharacterForm());

		return "characters/edit";

	}

}
