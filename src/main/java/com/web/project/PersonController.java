package com.web.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class PersonController {

    @GetMapping("/add")
    public String personForm(Person person) {
        return "add";
    }

    @PostMapping("/add")
    public String personSend(@Valid Person person, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "add";
        }else{
            person.writeToFile();
        }
        return "greeting";
    }
}
