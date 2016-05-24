package hu.inf.unideb.dungeonraider.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hu.inf.unideb.dungeonraider.domain.Armor;
import hu.inf.unideb.dungeonraider.domain.Item;
import hu.inf.unideb.dungeonraider.domain.ItemType;
import hu.inf.unideb.dungeonraider.domain.PlayersCharacter;
import hu.inf.unideb.dungeonraider.domain.Shield;
import hu.inf.unideb.dungeonraider.domain.Weapon;
import hu.inf.unideb.dungeonraider.service.ItemException;
import hu.inf.unideb.dungeonraider.service.ItemService;
import hu.inf.unideb.dungeonraider.service.MissingEntityException;
import hu.inf.unideb.dungeonraider.service.PlayerService;

/**
 * Shop views controller class.
 * 
 * @author FV
 *
 */
@Controller("shopController")
@RequestMapping("/shop")
@SessionAttributes(types = ShopForm.class)
public class ShopController extends AbstractController {

	/** The <code>autowired</code> item service <code>spring enterprise bean</code>. */
	@Autowired
	private ItemService itemService;
	/** The <code>autowired</code> player service <code>spring enterprise bean</code>. */
	@Autowired
	private PlayerService playerService;

	/** SLF4J Logger. */
	private final Logger log = LoggerFactory.getLogger(ShopController.class);

	/**
	 * Shop items view handler.
	 * 
	 * @param model the model
	 * @param id the character id
	 * @param form the shop form
	 * @return the view name
	 */
	@RequestMapping(value = "/items", method = RequestMethod.GET, produces = "text/html")
	public String shop(Model model, @RequestParam("id") int id, ShopForm form) {

		PlayersCharacter pc = playerService.findById(id);
		if (pc == null) {
			log.error("Internal problem occured while handled shop/items request.");
			return "redirect:/500.html";
		}

		form.setPlayerId(id);
		form.setArmors(itemService.listArmors(id, form.getArmorCanBuy()));
		form.setWeapons(itemService.listWeapons(id, form.getWeaponCanBuy()));
		form.setShields(itemService.listShields(id, form.getShieldCanBuy()));
		form.setPotions(itemService.listPotions(id, form.getPotionCanBuy()));
		form.setGold(pc.getGold());
		form.setLoadCapacity(pc.getLoadCapacity());

		//
		// form.setArmors(itemService.listArmors(id, false));
		// form.setWeapons(itemService.listWeapons(id, false));
		// form.setShields(itemService.listShields(id, false));

		// form.setPotions(itemService.listPotions(id, false));
		model.addAttribute("form", form);
		form.setCharacterId(pc.getId());
		model.addAttribute("playerCharacter", pc);

		return "shop/items";

	}

	/**
	 * Handling item buying submission.
	 * 
	 * @param model the model
	 * @param id the chracter id
	 * @param type the item type
	 * @param form the shop form
	 * @param redirectAttrs the redirect attributes
	 * @return the view name
	 */
	@RequestMapping(value = "/buy", method = RequestMethod.GET, produces = "text/html")
	public String shopBuy(Model model, @RequestParam("id") int id, @RequestParam("type") ItemType type, ShopForm form,
			RedirectAttributes redirectAttrs) {
		PlayersCharacter pc = playerService.findById(form.getPlayerId());
		if (pc == null) {
			log.error("Internal problem occured while handled chracter item buying submision. Character not found..");
			addErrorMsg(redirectAttrs, "error.notFoundCharacter");
			return "redirect:/500.html";
		}

		try {
			itemService.buy(type, id, form.getPlayerId());
		} catch (MissingEntityException ex) {

			log.error("Internal problem occured while handled characters item buying. Item not found.");
			addErrorMsg(redirectAttrs, "error.notFoundItem");
			return "redirect:/shop/items?id=" + pc.getId();

		} catch (ItemException ex) {
			log.error("Players character havent got enough gold for this item, or has too many items!");
			addErrorMsg(redirectAttrs, ex.getMessage());
			return "redirect:/shop/items?id=" + pc.getId();

		}
		addSuccessMsg(redirectAttrs, "success.itemBuyed");
		model.addAttribute("playerCharacter", pc);
		return "redirect:/shop/items?id=" + pc.getId();

	}

	/**
	 * Handling item buying and equipping submission.
	 * 
	 * @param model the model
	 * @param id the chracter id
	 * @param type the item type
	 * @param form the shop form
	 * @param redirectAttrs the redirect attributes
	 * @return the view name
	 */
	@RequestMapping(value = "/buyandequip", method = RequestMethod.GET, produces = "text/html")
	public String shopBuyAndEquip(Model model, @RequestParam("id") int id, @RequestParam("type") ItemType type, ShopForm form,
			RedirectAttributes redirectAttrs) {
		PlayersCharacter pc = playerService.findById(form.getPlayerId());
		if (pc == null) {
			log.error("Internal problem occured while handled characters item buying submision. Character not found.");
			addErrorMsg(redirectAttrs, "error.notFoundCharacter");
			return "redirect:/500.html";
		}

		try {
			itemService.buy(type, id, form.getPlayerId());
		} catch (MissingEntityException ex) {

			log.error("Internal problem occured while handled characters item buying. Item not found.");
			addErrorMsg(redirectAttrs, "error.notFoundItem");
			return "redirect:/shop/items?id=" + pc.getId();
		} catch (ItemException ex) {
			log.error("Players character havent got enough gold for this item or has too many items!");
			addErrorMsg(redirectAttrs, ex.getMessage());
			return "redirect:/shop/items?id=" + pc.getId();

		}
		addSuccessMsg(redirectAttrs, "success.itemBuyed");
		try {
			playerService.equipItem(type, id, form.getPlayerId());
		} catch (MissingEntityException ex) {

			log.error("Internal problem occured while handled characters item equipping.");
			addErrorMsg(redirectAttrs, "error.cantEquiped");
			return "redirect:/shop/items?id=" + pc.getId();
		}
		addSuccessMsg(redirectAttrs, "success.itemEquipped");

		model.addAttribute("playerCharacter", pc);
		return "redirect:/shop/items?id=" + pc.getId();

		// return "shop/items";

	}

	@RequestMapping(value = "/item", method = RequestMethod.GET, produces = "text/html")
	public String viewItem(Model model, @RequestParam("id") int id, @RequestParam("type") ItemType type,
			@RequestParam("characterId") Integer characterId, RedirectAttributes redirectAttrs) {
		PlayersCharacter pc = playerService.findById(characterId);
		if (pc == null) {
			log.error("Internal problem occured while handled characters item buying submision. Character not found.");
			addErrorMsg(redirectAttrs, "error.notFoundCharacter");
			return "redirect:/500.html";
		}

		ItemForm form = new ItemForm();

		switch (type) {
		case SHIELD:
			Shield shield = itemService.findShieldById(id);
			if (shield != null) {
				form.setDefPlus(shield.getDefPlus());
				form.setAtkMinus(shield.getAtkMinus());
				itemSetForForm(shield, form);
			} else {
				addErrorMsg(redirectAttrs, "error.notFoundItem");
				return "redirect:/shop/items?id=" + pc.getId();
			}
			break;
		case ARMOR:
			Armor armor = itemService.findArmorById(id);
			if (armor != null) {
				form.setDefPlus(armor.getDefPlus());
				form.setAtkMinus(armor.getAtkMinus());
				form.setHealthPlus(armor.getHealthPlus());
				itemSetForForm(armor, form);
			} else {
				addErrorMsg(redirectAttrs, "error.notFoundItem");
				return "redirect:/shop/items?id=" + pc.getId();
			}
			break;
		case WEAPON:
			Weapon weapon = itemService.findWeaponById(id);
			if (weapon != null) {

				form.setAtk(weapon.getAtk());
				form.setDef(weapon.getDef());
				form.setDamage(weapon.getDamage());
				itemSetForForm(weapon, form);
			} else {
				addErrorMsg(redirectAttrs, "error.notFoundItem");
				return "redirect:/shop/items?id=" + pc.getId();
			}
			break;
		case POTION:
			break;
		default:
			break;

		}

		// model.addAttribute("playerCharacterId", pc.getId());
		model.addAttribute("playerCharacter", pc);
		model.addAttribute("form", form);

		return "shop/item";

		// return "shop/items";

	}

	private void itemSetForForm(Item item, ItemForm form) {
		form.setId(item.getId());
		form.setValue(item.getValue());
		form.setWeight(item.getWeight());
		form.setName(item.getName());
		form.setType(item.getType());
		form.setDescription(item.getDescription());

	}

}
