package hu.inf.unideb.dungeonraider.web;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class AbstractController {

	/**
	 * Add error message to the model.
	 * 
	 * @param model the model
	 * @param code the message code
	 */
	protected void addErrorMsg(Model model, String code) {
		model.addAttribute("errorMsg", code);
	}

	/**
	 * Add error message to the redirect attributes.
	 * 
	 * @param redirectAttributes the redirect attributes
	 * @param code the message code
	 */
	protected void addErrorMsg(RedirectAttributes redirectAttributes, String code) {
		redirectAttributes.addFlashAttribute("errorMsg", code);
	}

	/**
	 * Add success message to the model.
	 * 
	 * @param model the model
	 * @param code the message code
	 */
	protected void addSuccessMsg(Model model, String code) {
		model.addAttribute("successMsg", code);
	}

	/**
	 * Add success message to the redirect attributes.
	 * 
	 * @param redirectAttributes the redirect attributes
	 * @param code the message code
	 */
	protected void addSuccessMsg(RedirectAttributes redirectAttributes, String code) {
		redirectAttributes.addFlashAttribute("successMsg", code);
	}

}
