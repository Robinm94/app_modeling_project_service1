package com.example.asssignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.asssignment.model.User;
import com.example.asssignment.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String index(@RequestParam(required = false) boolean logout,
			HttpSession session) {
		if (logout) {
			session.invalidate();
		}
		return "index";
	}

	@PostMapping("/login")
	public String login(@RequestParam String email, @RequestParam String password, Model model, HttpSession session) {
		try {
			User user = userService.getUserByEmail(email).block();
			if (user != null && user.getPassword().equals(password)) {
				session.setAttribute("userId", user.getUserId());
				return "redirect:/order";
			}

			model.addAttribute("error", "Invalid email or password");
			return "index";
		} catch (Exception e) {
			model.addAttribute("error", "An error occurred: " + e.getMessage());
			return "index";
		}

	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public String registerUser(@ModelAttribute User user, Model model) {
		try {
			userService.saveUser(user).block(); // Block for simplicity, consider proper reactive handling
			model.addAttribute("success", "Registration successful! Please login.");
			return "redirect:/";
		} catch (Exception e) {
			model.addAttribute("error", "Registration failed: " + e.getMessage());
			return "register";
		}
	}
}
