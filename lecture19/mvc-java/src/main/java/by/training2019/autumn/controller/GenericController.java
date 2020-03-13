package by.training2019.autumn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GenericController {
    @GetMapping(value = "/")
    public String index(Model model){
        model.addAttribute("title", "Home page");
        model.addAttribute("appTitle", "Spring MVC demo app");
        model.addAttribute("welcome", "Welcome to Students app!");
        model.addAttribute("students", "Get list of students");
        model.addAttribute("faculties", "Get list of faculties");

        return "/index";
    }
}
