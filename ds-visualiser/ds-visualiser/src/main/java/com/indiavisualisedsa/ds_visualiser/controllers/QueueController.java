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

import com.indiavisualisedsa.ds_visualiser.models.Queue;
import com.indiavisualisedsa.ds_visualiser.models.Stack;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/queue")
@SessionAttributes("queue")
public class QueueController {

	@GetMapping("/initializePage")
	public String initializePage() {
		return "queue-init";
	}

	@PostMapping("/initialize")
	public String initializeQueue(@RequestParam("size") int size, Model model) {
		model.addAttribute("queue", new Queue(size));
		return "redirect:/queue/view";
	}

	@GetMapping("/view")
	public String viewQueue(@ModelAttribute("queue") Queue queue, Model model) {
		int[] elements = queue != null ? queue.getElements() : new int[0];
		model.addAttribute("elements", elements);
		model.addAttribute("frontPointer", queue.getfrontPointer());
		model.addAttribute("rearPointer", queue.getrearPointer());
		return "queueDisplay";
	}

	@PostMapping("/insert")
	public String insertItem(@RequestParam("item") Integer item, @ModelAttribute("queue") Queue queue,
			RedirectAttributes redirectAttributes) {

		String message = queue.insert(item);
		redirectAttributes.addFlashAttribute("message", message);
		redirectAttributes.addAttribute("elements", queue.getElements());
		redirectAttributes.addAttribute("frontPointer", queue.getfrontPointer());
		redirectAttributes.addAttribute("rearPointer", queue.getrearPointer());
		return "redirect:/queue/view";
	}

	@PostMapping("/delete")
	public String deleteItem(@ModelAttribute("queue") Queue queue, RedirectAttributes redirectAttributes) {
		String message = queue.delete();
		redirectAttributes.addFlashAttribute("message", message);
		redirectAttributes.addAttribute("elements", queue.getElements());
		redirectAttributes.addAttribute("frontPointer", queue.getfrontPointer());
		redirectAttributes.addAttribute("rearPointer", queue.getrearPointer());
		return "redirect:/queue/view";
	}
}
