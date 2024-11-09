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

import com.indiavisualisedsa.ds_visualiser.models.CircularQueue;

@Controller
@RequestMapping("/circularqueue")
@SessionAttributes("circularqueue")
public class CircularQueueController {


	@GetMapping("/initializePage")
	public String initializePage() {
		return "circularqueue-init";
	}

	@PostMapping("/initialize")
	public String initializeQueue(@RequestParam("size") int size, Model model) {
		model.addAttribute("circularqueue", new CircularQueue(size));
		return "redirect:/circularqueue/view";
	}

	@GetMapping("/view")
	public String viewQueue(@ModelAttribute("circularqueue") CircularQueue circularqueue, Model model) {
		int[] elements = circularqueue != null ? circularqueue.getElements() : new int[0];
		model.addAttribute("elements", elements);
		model.addAttribute("frontPointer", circularqueue.getFrontPointer());
		model.addAttribute("rearPointer", circularqueue.getRearPointer());
		return "circularqueueDisplay";
	}

	@PostMapping("/insert")
	public String insertItem(@RequestParam("item") Integer item, @ModelAttribute("circularqueue") CircularQueue circularqueue,
			RedirectAttributes redirectAttributes) {

		String message = circularqueue.insert(item);
		redirectAttributes.addFlashAttribute("message", message);
		redirectAttributes.addAttribute("elements", circularqueue.getElements());
		redirectAttributes.addAttribute("frontPointer", circularqueue.getFrontPointer());
		redirectAttributes.addAttribute("rearPointer", circularqueue.getRearPointer());
		return "redirect:/circularqueue/view";
	}

	@PostMapping("/delete")
	public String deleteItem(@ModelAttribute("circularqueue") CircularQueue circularqueue, RedirectAttributes redirectAttributes) {
		String message = circularqueue.delete();
		redirectAttributes.addFlashAttribute("message", message);
		redirectAttributes.addAttribute("elements", circularqueue.getElements());
		redirectAttributes.addAttribute("frontPointer", circularqueue.getFrontPointer());
		redirectAttributes.addAttribute("rearPointer", circularqueue.getRearPointer());
		return "redirect:/circularqueue/view";
	}


}
