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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hu.inf.unideb.dungeonraider.domain.PlayersCharacter;
import hu.inf.unideb.dungeonraider.service.PlayerService;

/**
 * Main controller.
 * 
 * @author FV
 *
 */
@Controller("mainController")
@RequestMapping("/")
@SessionAttributes(types = LoginForm.class)
public class DungeonRaiderMainController {

	@Autowired
	private PlayerService playerService;

	/** SLF4J Logger */
	private final Logger log = LoggerFactory.getLogger(DungeonRaiderMainController.class);

	/**
	 * Login display
	 * 
	 * @param form the login form with field to login
	 * @param model the model
	 * @return the view name
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET, produces = "text/html")
	public String loginForm(LoginForm form, Model model) {
		log.info("Login view displayed");
		model.addAttribute("form", form);

		return "login";

	}

	/**
	 * Login form submit
	 * 
	 * @param form the login form
	 * @param model the model
	 * @param errors the field errors
	 * @param redirectAttrs the redirect attributes
	 * @return the view name
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "text/html")
	public String loginFormSubmit(LoginForm form, Model model, Errors errors, RedirectAttributes redirectAttrs) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "validation.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "validation.required");

		if (errors.hasErrors()) {
			log.warn("Login form submit request failed!");
			return "login";
		}

		PlayersCharacter pc = playerService.findByNameAndPassword(form.getName(), form.getPassword());
		if (pc == null) {
			redirectAttrs.addFlashAttribute("errorMsg", "login.wrongPasswordOrLoginName");
			log.warn("Character not found with name:" + form.getName());
			return "redirect:/login.html";
		}

		log.info("Player logged in with character: " + form.getName());
		return "redirect:/characters/edit?id=" + pc.getId();

	}

	/**
	 * New character handler
	 * 
	 * @param model the model
	 * @return the create view name
	 */
	@RequestMapping(value = "/login", params = "newCharacter", method = RequestMethod.POST, produces = "text/html")
	public String loginFormSubmitStartNew(Model model) {

		model.addAttribute(new CharacterForm());
		log.info("New character started!");
		return "character/create";

	}

}
