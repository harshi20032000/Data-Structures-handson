package com.indiavisualisedsa.ds_visualiser.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.indiavisualisedsa.ds_visualiser.models.SinglyLinkedList;

@Controller
@RequestMapping("/sll")
@SessionAttributes("singlyLinkedList")
public class SingleLinkedListController {

	@GetMapping("/initializePage")
	public String initializePage() {
		return "sll-init";
	}
	
	@PostMapping("/initialize")
	public String initializeQueue(@RequestParam("data") int data, Model model) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList(data);
		model.addAttribute("singlyLinkedList", singlyLinkedList);
		return "redirect:/sll/view";
	}
	
	@GetMapping("/view")
	public String viewSinglyLinkedList(@ModelAttribute("singlyLinkedList") SinglyLinkedList singlyLinkedList, Model model) {
		String elements = singlyLinkedList != null ? singlyLinkedList.getElementsAsString() : "";
		model.addAttribute("elements", elements);
		return "singlyLinkedListDisplay";
	}
	
}
