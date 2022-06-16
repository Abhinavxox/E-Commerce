package com.bway.project_2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

	@GetMapping("/")
	public String index(HttpSession session) {
		
		return "index";
	}
	
	@GetMapping("/men")
	public String men(HttpSession session) {
		
		return "index_men";
	}
	
	@GetMapping("/women")
	public String women(HttpSession session) {
		
		return "index_women";
	}
	
	@GetMapping("/kids")
	public String kids(HttpSession session) {
		
		return "index_kids";
	}
	
	@GetMapping("/faq")
	public String faq(HttpSession session) {
		
		return "faq";
	}
	
	
	

}
