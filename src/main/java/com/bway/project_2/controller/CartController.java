package com.bway.project_2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bway.project_2.global.GlobalData;
import com.bway.project_2.model.Product;
import com.bway.project_2.service.ProductService;

@Controller
public class CartController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/addToCart/{id}")
	public String addToCart(@PathVariable int id, HttpSession session, HttpServletRequest request) {
		
		if(request.getSession().getAttribute("activeuser")!=null) {
			GlobalData.cart.add(productService.findByID(id).get());
			return "redirect:/cart";
		}
		return "redirect:/login"; 
	}
	
	@GetMapping("/cart")
	public String openCart(Model model,HttpSession session, HttpServletRequest request) {
		
		if(request.getSession().getAttribute("activeuser")!=null) {
			model.addAttribute("cartCount", GlobalData.cart.size());
			model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
			model.addAttribute("cart", GlobalData.cart);
			return "cart"; 
		}
		return "login";
	}
	
	
	@PostMapping("/cart/{id}")
	public String cartAdd(HttpSession session, HttpServletRequest request) {
		if(request.getSession().getAttribute("activeuser")==null) {
			return "login";
		}
		
		return "cart";
	}
	
	@GetMapping("/checkout")
	public String chekcout(Model model,HttpSession session, HttpServletRequest request) {
		
		if(request.getSession().getAttribute("activeuser")!=null) {
			model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
			return "checkout";   
		}
		return "login";
	}
	
	@GetMapping("/payNow")
	public String payment(Model model,HttpSession session, HttpServletRequest request) {
		if(request.getSession().getAttribute("activeuser")!=null) {
			return"paymemt";
		}
		return "login";
	}
	
	@PostMapping("/payNow")
	public String payNow(Model model,HttpSession session, HttpServletRequest request) {
		if(request.getSession().getAttribute("activeuser")!=null) {
			GlobalData.cart.clear();
			return"redirect:/cart";
		}
		return "login";
	}
	
	@GetMapping("/cart/removeItem/{index}")
	public String cartItemRemove(@PathVariable int index, HttpSession session, HttpServletRequest request) {
		
		
		if (request.getSession().getAttribute("activeuser") != null) {
			GlobalData.cart.remove(index-1);
			return "redirect:/cart";
		}
		return "login";
		
	}
	
	
}
