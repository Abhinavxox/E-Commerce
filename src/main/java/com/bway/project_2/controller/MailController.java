package com.bway.project_2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bway.project_2.utilities.EmailUtil;

@Controller
public class MailController {
	
	@Autowired
	private   JavaMailSender javaMailSender;
	
	@PostMapping("/contact")
	public String sendMail(HttpServletRequest request) {
		String to = request.getParameter("to");
		String subject = "Hello from the other side";
		String message = "Welcome to our Ray-Ban chasma pasal, Ratnapark";
		sendEmail(to, subject, message);
		return "redirect:/faq";
	}
	
	public void sendEmail(String to, String subject, String message) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(to);
		msg.setSubject(subject);
		msg.setText(message);
		javaMailSender.send(msg);
	}
	
	//for contact page
	@GetMapping("/contacts")
	public String getContact() {
		return "contact";
	}
	
	@PostMapping("/contacts")
	public String giveFeedback(HttpServletRequest request) {
		String to = "abhinavxox@gmail.com";
		String subject1 = request.getParameter("email");
		String subject = "From :"+subject1;
		String msg1 = request.getParameter("name");
		String msg2 = request.getParameter("phone");
		String msg3 = request.getParameter("message");
		String message = msg1 + "\n" + msg2 + "\n" + msg3;
		sendEmail(to, subject, message);
		return "contact";
	}
}
