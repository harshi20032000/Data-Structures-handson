package com.indiavisualisedsa.ds_visualiser.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.indiavisualisedsa.ds_visualiser.models.Stack;

@Controller
@RequestMapping("/stack")
@SessionAttributes("stack")
public class StackController {

	@GetMapping("/initializePage")
	public String initializePage() {
		return "stack-init";
	}

	@PostMapping("/initialize")
	public String initializeStack(@RequestParam("size") int size, Model model) {
		model.addAttribute("stack", new Stack(size));
		return "redirect:/stack/view";
	}

	@GetMapping("/view")
	public String viewStack(@ModelAttribute("stack") Stack stack, Model model) {
		int[] elements = stack != null ? stack.getElements() : new int[0];
		model.addAttribute("stackElements", elements);
		model.addAttribute("stackSize", stack != null ? stack.size() : 0);
		model.addAttribute("spPointer", stack != null ? stack.getSP() : -1);
		return "stackDisplay";
	}

	@PostMapping("/push")
	public String push(@RequestParam("value") Integer value, @ModelAttribute("stack") Stack stack,
			RedirectAttributes redirectAttributes) {

		String message = stack.push(value);
		redirectAttributes.addFlashAttribute("stackElements", stack.getElements());
		redirectAttributes.addFlashAttribute("message", message);
		redirectAttributes.addFlashAttribute("spPointer", stack.getSP());
		return "redirect:/stack/view";
	}

	@PostMapping("/pop")
	public String pop(@ModelAttribute("stack") Stack stack, RedirectAttributes redirectAttributes) {
		String message = stack.pop();
		redirectAttributes.addFlashAttribute("stackElements", stack.getElements());
		redirectAttributes.addFlashAttribute("message", message);
		redirectAttributes.addFlashAttribute("spPointer", stack.getSP());
		return "redirect:/stack/view";
	}
}
