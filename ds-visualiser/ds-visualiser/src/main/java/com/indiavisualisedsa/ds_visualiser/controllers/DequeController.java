package com.indiavisualisedsa.ds_visualiser.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.indiavisualisedsa.ds_visualiser.models.Deque;

@Controller
@RequestMapping("/deque")
@SessionAttributes("deque")
public class DequeController {

	@GetMapping("/initializePage")
	public String initializePage() {
		return "deque-init";
	}

	@PostMapping("/initialize")
	public String initializeDeque(@RequestParam("size") int size, Model model) {
		model.addAttribute("deque", new Deque(size));
		return "redirect:/deque/view";
	}

	@GetMapping("/view")
	public String viewDeque(@ModelAttribute("deque") Deque deque, Model model) {
		int[] elements = deque != null ? deque.getElements() : new int[0];
		model.addAttribute("elements", elements);
		model.addAttribute("frontPointer", deque.getFrontPointer());
		model.addAttribute("rearPointer", deque.getRearPointer());
		return "dequeDisplay";
	}

	@PostMapping("/insertFront")
	public String insertFrontItem(@RequestParam("item") Integer item, @ModelAttribute("deque") Deque deque,
			RedirectAttributes redirectAttributes) {

		String message = deque.insertFront(item);
		redirectAttributes.addFlashAttribute("message", message);
		redirectAttributes.addAttribute("elements", deque.getElements());
		redirectAttributes.addAttribute("frontPointer", deque.getFrontPointer());
		redirectAttributes.addAttribute("rearPointer", deque.getRearPointer());
		return "redirect:/deque/view";
	}

	@PostMapping("/deleteFront")
	public String deleteFrontItem(@ModelAttribute("deque") Deque deque, RedirectAttributes redirectAttributes) {
		String message = deque.deleteFront();
		redirectAttributes.addFlashAttribute("message", message);
		redirectAttributes.addAttribute("elements", deque.getElements());
		redirectAttributes.addAttribute("frontPointer", deque.getFrontPointer());
		redirectAttributes.addAttribute("rearPointer", deque.getRearPointer());
		return "redirect:/deque/view";
	}
	
	@PostMapping("/insertRear")
	public String insertRearItem(@RequestParam("item") Integer item, @ModelAttribute("deque") Deque deque,
			RedirectAttributes redirectAttributes) {

		String message = deque.insertRear(item);
		redirectAttributes.addFlashAttribute("message", message);
		redirectAttributes.addAttribute("elements", deque.getElements());
		redirectAttributes.addAttribute("frontPointer", deque.getFrontPointer());
		redirectAttributes.addAttribute("rearPointer", deque.getRearPointer());
		return "redirect:/deque/view";
	}

	@PostMapping("/deleteRear")
	public String deleteRearItem(@ModelAttribute("deque") Deque deque, RedirectAttributes redirectAttributes) {
		String message = deque.deleteRear();
		redirectAttributes.addFlashAttribute("message", message);
		redirectAttributes.addAttribute("elements", deque.getElements());
		redirectAttributes.addAttribute("frontPointer", deque.getFrontPointer());
		redirectAttributes.addAttribute("rearPointer", deque.getRearPointer());
		return "redirect:/deque/view";
	}
}
