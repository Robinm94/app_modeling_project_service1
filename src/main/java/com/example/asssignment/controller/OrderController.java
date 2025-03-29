package com.example.asssignment.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.asssignment.model.Order;
import com.example.asssignment.service.OrderService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping()
	public String orders(Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("newOrder", new Order());
		List<Order> orderList = orderService.getOrdersByUserId(session.getAttribute("userId").toString())
                .collectList()
                .block();
		model.addAttribute("orders", orderList);
		return "orders";
	}
	
	@PostMapping("/create")
	public String createOrder(@ModelAttribute("newOrder") Order order, Model model, RedirectAttributes redirectAttributes, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		order.setUserId(session.getAttribute("userId").toString());
		orderService.saveOrder(order).block(); 
		redirectAttributes.addFlashAttribute("success", "Order created successfully!");
		return "redirect:/order";
		
	}
	
}
