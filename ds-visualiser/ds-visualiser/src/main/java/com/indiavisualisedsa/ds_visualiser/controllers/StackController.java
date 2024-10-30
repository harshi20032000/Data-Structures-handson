package com.indiavisualisedsa.ds_visualiser.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.indiavisualisedsa.ds_visualiser.models.Stack;

@Controller
@SessionAttributes("stack")
public class StackController {

    @ModelAttribute("stack")
    public Stack<Integer> initializeStack() {
        return new Stack<>(); // Each user gets a unique session-scoped stack instance
    }

    @GetMapping("/stack")
    public String viewStack(@ModelAttribute("stack") Stack<Integer> stack, Model model) {
        model.addAttribute("stackElements", stack.getElements());
        return "stack"; // Thymeleaf template name
    }

    @PostMapping("/stack/push")
    public String push(@RequestParam("value") Integer value, @SessionAttribute("stack") Stack<Integer> stack) {
        stack.push(value);
        return "redirect:/stack"; // Redirect to refresh the view
    }

    @PostMapping("/stack/pop")
    public String pop(@ModelAttribute("stack") Stack<Integer> stack) {
        stack.pop();
        return "redirect:/stack";
    }
}
