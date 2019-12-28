package com.web.project;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

public class Mail {
    private String email;
    private String text = "";

    public void setEmail(String email) {
        this.email = email;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getEmail() {
        return email;
    }

    public String getText() {
        return text;
    }

    public void sendMail() throws IOException, MessagingException {

        try {
            String pass= "java12345";


            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return (new PasswordAuthentication("javaspringbootmail@gmail.com", pass));
                }
            });
            Message msg = new MimeMessage(session);
            InternetAddress addressFrom = new InternetAddress("javaspringbootmail@gmail.com");
            msg.setFrom(addressFrom);
            InternetAddress addressTo = new InternetAddress(email);
            msg.setRecipient(Message.RecipientType.TO, addressTo);
            msg.setSubject("by java");
            msg.setText(text);
            Transport.send(msg);
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
