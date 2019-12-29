package com.web.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class PersonController {

        @GetMapping("/add")
    public String personForm(@ModelAttribute @Valid Person person, Errors errors, Model model) {
        return "add";
    }

    @PostMapping("/add")
    public String personSend(@ModelAttribute @Valid Person person, Errors errors, Model model) {
        if(errors.hasErrors()){
            model.addAttribute("add", "Wrong data");
        }else{
            person.writeToFile();
        }
        return "greeting";
    }
}
