package com.web.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShowResultController {

    @GetMapping("/showResult")
    public String showResultForm(@ModelAttribute Person person,@ModelAttribute Mail mail, Model model) {
        mail.setEmail(person.getEmail());
        mail.setText("");
        model.addAttribute("sendMail", mail);

        return "showResult";
    }
}
