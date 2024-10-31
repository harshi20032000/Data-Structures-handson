package com.indiavisualisedsa.ds_visualiser.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.indiavisualisedsa.ds_visualiser.models.Stack;

@Controller
@SessionAttributes("stack")
public class StackController {

	@ModelAttribute("stack")
	public Stack initializeStack() {
		return null;
	}

	 @GetMapping("/stack")
	    public String viewStack(@ModelAttribute("stack") Stack stack, Model model) {
	        model.addAttribute("stackElements", stack != null ? stack.getElements() : new int[0]);
	        model.addAttribute("stackSize", stack != null ? stack.size() : 0);
	        model.addAttribute("spPointer", stack != null ? stack.getSP() : -1);
	        return "stack";
	    }

	@GetMapping("/stack/initializePage")
	public String initializePage() {
		return "initializePage"; // Page to enter stack size
	}

	@PostMapping("/stack/initialize")
	public String initializeStack(@RequestParam("size") int size, Model model, SessionStatus status) {
		model.addAttribute("stack", new Stack(size));
		return "redirect:/stack";
	}

	@PostMapping("/stack/push")
	public String push(@RequestParam("value") Integer value, @ModelAttribute("stack") Stack stack, RedirectAttributes redirectAttributes) {

		String message = stack.push(value);
		redirectAttributes.addFlashAttribute("message", message);
		redirectAttributes.addFlashAttribute("spPointer", stack.getSP());
		return "redirect:/stack";
	}

	@PostMapping("/stack/pop")
	public String pop(@ModelAttribute("stack") Stack stack, RedirectAttributes redirectAttributes) {
		String message = stack.pop();
		redirectAttributes.addFlashAttribute("message", message);
		redirectAttributes.addFlashAttribute("spPointer", stack.getSP());
		return "redirect:/stack";
	}
}
