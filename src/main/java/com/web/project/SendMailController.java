package com.web.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;
import java.io.IOException;

@Controller
public class SendMailController {

    @PostMapping("/sendMail")
    public String sendMailForm(@ModelAttribute  Mail mail, Model model) {
        String str = "";
        try {
            if(!str.equals(mail.getText())) {
                mail.sendMail();
                return "greeting";
            }
        }
        catch (MessagingException ex){
            ex.printStackTrace();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }

        return "sendMail";
    }
}