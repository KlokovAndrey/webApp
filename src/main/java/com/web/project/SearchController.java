package com.web.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    @GetMapping("/search")
    public String searchForm(@ModelAttribute Person person, Model model) {
        if(person.getFirstName() != "" || person.getSecondName() != ""){
            if (!person.search()) return "error";
            model.addAttribute("showResult", person);
            return "showResult";
        }
        return "search";
    }
}
