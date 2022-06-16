package com.bway.project_2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bway.project_2.global.GlobalData;
import com.bway.project_2.model.User;
import com.bway.project_2.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/signup")
	public String signup(HttpSession session, HttpServletRequest request) {
		if(request.getSession().getAttribute("activeuser")==null) {
			return "signup";
		}
		
		return "login";
	}
	
	@PostMapping("/signup")
	public String userSignup(@ModelAttribute User user, HttpSession session) {
		userRepo.save(user);
		return "login";
	}
	
	@GetMapping("/login")
	public String login(HttpSession session, HttpServletRequest request) {
		if(request.getSession().getAttribute("activeuser")==null) {
			return "login";
		}
		return "index";
	}
	
	@PostMapping("/login")
	public String userLogin(@ModelAttribute User user, Model model, HttpSession session) {
		User ur = userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		
		if(ur!=null) {
			session.setAttribute("activeuser", ur.getUsername());
			session.setAttribute("loggedIn", true);
			return "index";
		}
		model.addAttribute("error", "User not found.");
		return "login";
	}
	
	@GetMapping("/logout")
	public String userLogout(HttpSession session) {
		session.invalidate();
		session.setAttribute("loggedIn", false);
		return "index";
	}
	
}
