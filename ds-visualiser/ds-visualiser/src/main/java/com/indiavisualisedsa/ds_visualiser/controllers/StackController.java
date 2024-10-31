package com.indiavisualisedsa.ds_visualiser.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.indiavisualisedsa.ds_visualiser.models.Stack;

@Controller
@SessionAttributes("stack")
public class StackController {

    @ModelAttribute("stack")
    public Stack initializeStack() {
        return null; // Start with no stack initialized
    }

    @GetMapping("/stack")
    public String viewStack(@ModelAttribute("stack") Stack stack, Model model) {
        if (stack == null) {
            return "redirect:/stack/initializePage";
        }
        model.addAttribute("stackElements", stack.getElements());
        model.addAttribute("stackSize", stack.size());
        return "stack";
    }

    @GetMapping("/stack/initializePage")
    public String initializePage() {
        return "initializePage"; // Page to enter stack size
    }

    @PostMapping("/stack/initialize")
    public String initializeStack(@RequestParam("size") int size, Model model) {
        model.addAttribute("stack", new Stack(size));
        return "redirect:/stack";
    }

    @PostMapping("/stack/push")
    public String push(@RequestParam("value") Integer value, @ModelAttribute("stack") Stack stack, Model model) {
        if (stack.size() == stack.getElements().length) {
            model.addAttribute("message", "Stack overflow - Unable to push!");
        } else {
            stack.push(value);
            model.addAttribute("message", value + " pushed to stack");
        }
        return "redirect:/stack";
    }

    @PostMapping("/stack/pop")
    public String pop(@ModelAttribute("stack") Stack stack, Model model) {
        if (stack.size() == 0) {
            model.addAttribute("message", "Stack underflow - Unable to pop!");
        } else {
            int poppedValue = stack.pop();
            model.addAttribute("message", "Element popped: " + poppedValue);
        }
        return "redirect:/stack";
    }
}
