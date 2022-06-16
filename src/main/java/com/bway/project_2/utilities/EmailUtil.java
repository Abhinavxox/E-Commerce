package com.bway.project_2.utilities;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class EmailUtil {
	
	@Autowired
	public static JavaMailSender javaMailSender;
    
    public static void sendEmail(String to, String subject, String message) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);
        msg.setSubject(subject);
        msg.setText(message);
        javaMailSender.send(msg);
    }
    
    public static void sendEmailWithAttachment(String to, String subject, String message) throws MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        
        helper.setTo(to);

        helper.setSubject(subject);

        // default = text/plain
        //helper.setText("Check attachment for image!");

        // true = text/html
        helper.setText(message);

        // hard coded a file path
        //FileSystemResource file = new FileSystemResource(new File("path/android.png"));

        helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));

        javaMailSender.send(msg);

    }
	

}
