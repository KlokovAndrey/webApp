package com.web.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua_parser.UserAgent;
//import .bitwalker.useragentutils.UserAgent;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class SearchController {

    @GetMapping("/search")
    public String searchForm(Model model, Person person) {
        model.addAttribute("search", person);
        return "search";
    }

    @PostMapping("/search")
    public String showForm(@ModelAttribute Person person, Model model, HttpServletRequest request) {
        if (!person.search()) return "error";
        String userAgent = request.getHeader("User-Agent");
        String time="Time: " + new Date();
        model.addAttribute("time", time);
        model.addAttribute("showResult", person);
        model.addAttribute("userAgent",  userAgent);
        return "showResult";
    }
}
