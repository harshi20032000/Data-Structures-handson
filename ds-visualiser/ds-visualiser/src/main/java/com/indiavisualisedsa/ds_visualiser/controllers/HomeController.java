package com.indiavisualisedsa.ds_visualiser.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String homePage(Model model) {
		Map<String, String> dataStructures = Map.of("Stack", "/stack/initializePage",
													"Queue", "/queue/initializePage",
													"CircularQueue", "/circularqueue/initializePage",
													"Deque", "/deque/initializePage",
													"SingleLinkedList", "/sll/initializePage"
		);
		model.addAttribute("dataStructures", dataStructures);
		return "index";
	}
}
