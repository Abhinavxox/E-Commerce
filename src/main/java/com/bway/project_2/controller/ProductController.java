package com.bway.project_2.controller;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.bway.project_2.model.Product;
import com.bway.project_2.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productservice;
	
	@GetMapping("/viewproduct/{id}")
	public String productView(@PathVariable int id, Model model, HttpSession session) {
			model.addAttribute("product", productservice.findByID(id).get());
			return "productView";
	}

}
