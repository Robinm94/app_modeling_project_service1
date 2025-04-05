package com.example.asssignment.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.asssignment.model.Order;
import com.example.asssignment.model.User;
import com.example.asssignment.request.AcctTransactionRequest;
import com.example.asssignment.request.MarketOrderRequest;
import com.example.asssignment.response.AcctTransactionResponse;
import com.example.asssignment.response.FeeResponse;
import com.example.asssignment.response.MarketOrderResponse;
import com.example.asssignment.service.OrderService;
import com.example.asssignment.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	

    @Autowired
    private ObjectMapper objectMapper;
    
    @Autowired
    private WebClient.Builder webClientBuilder;
	
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
	
//	@PostMapping("/create")
//	public String createOrder(@ModelAttribute("newOrder") Order order, Model model, RedirectAttributes redirectAttributes, HttpSession session) {
//		if (session.getAttribute("userId") == null) {
//			return "redirect:/";
//		}
//		String accTransactionUrl = "http://accttransactionservice/confirmBuy";
//		order.setUserId(session.getAttribute("userId").toString());
//		Order newOrderResponse = orderService.saveOrder(order).block(); 
//		User user = userService.getUser(order.getUserId()).block();
//		double newBalance = 0;
//		if (order.getOrderType().equals("SELL")) {
//			accTransactionUrl = "http://accttransactionservice/confirmSell";
//			newBalance = user.getBalance() + (newOrderResponse.getPrice() * newOrderResponse.getQuantity());
//		}
//		else {
//			accTransactionUrl = "http://accttransactionservice/confirmBuy";
//			newBalance = user.getBalance() - (newOrderResponse.getPrice() * newOrderResponse.getQuantity());
//		}
//		try {
//			AcctTransactionRequest transactionRequest = new AcctTransactionRequest(order.getOrderId(), order.getOrderType(),order.getTickerSymbol(), 20.00, (order.getPrice() * order.getQuantity()),newBalance );
//			user.setBalance(newBalance);
//			userService.updateUser(user).block();
//			String accTransactionResponse = webClientBuilder.build().post().uri(accTransactionUrl).bodyValue(transactionRequest)
//					.retrieve().bodyToMono(String.class).block();
//			AcctTransactionResponse transaction = objectMapper.readValue(accTransactionResponse, AcctTransactionResponse.class);
//			System.out.println("Transaction: " + transaction);
//			String formData = "feeType=" + order.getOrderType() +
//	                "&price=" + order.getPrice() +
//	                "&quantity=" + order.getQuantity();
//			String feeResponse = webClientBuilder.build().post().uri("http://feeservice/fees/calculate").header("Content-Type", "application/x-www-form-urlencoded")
//					.bodyValue(formData).retrieve().bodyToMono(String.class).block();
//			FeeResponse fee = objectMapper.readValue(feeResponse, FeeResponse.class);
//			System.out.println("Fee: " + fee);
//			MarketOrderRequest marketOrderRequest = new MarketOrderRequest(order.getOrderId(), transaction.getTransactionId(), fee.getFeeId(), 500, 700, order.getOrderType());
//			String marketOrderResponse = webClientBuilder.build().post().uri("http://marketorderservice/api/marketorder")
//					.bodyValue(marketOrderRequest).retrieve().bodyToMono(String.class).block();
//			System.out.println("Market Order Response: " + marketOrderResponse);
//			MarketOrderResponse marketOrder = objectMapper.readValue(marketOrderResponse, MarketOrderResponse.class);
//			System.out.println("Market Order: " + marketOrder);
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		redirectAttributes.addFlashAttribute("success", "Order created successfully!");
//		return "redirect:/order";
//		
//	}
	
	@PostMapping("/create")
	public String createOrder(@ModelAttribute("newOrder") Order order, Model model, HttpSession session) {
	    if (session.getAttribute("userId") == null) {
	        return "redirect:/";
	    }
	    String accTransactionUrl = "http://accttransactionservice/confirmBuy";
	    order.setUserId(session.getAttribute("userId").toString());
	    Order newOrderResponse = orderService.saveOrder(order).block();
	    User user = userService.getUser(order.getUserId()).block();
	    double newBalance = 0;
	    if (order.getOrderType().equals("SELL")) {
	        accTransactionUrl = "http://accttransactionservice/confirmSell";
	        newBalance = user.getBalance() + (newOrderResponse.getPrice() * newOrderResponse.getQuantity());
	    } else {
	        accTransactionUrl = "http://accttransactionservice/confirmBuy";
	        newBalance = user.getBalance() - (newOrderResponse.getPrice() * newOrderResponse.getQuantity());
	    }
	    try {
	        AcctTransactionRequest transactionRequest = new AcctTransactionRequest(order.getOrderId(), order.getOrderType(), order.getTickerSymbol(), 20.00, (order.getPrice() * order.getQuantity()), newBalance);
	        user.setBalance(newBalance);
	        userService.updateUser(user).block();
	        String accTransactionResponse = webClientBuilder.build().post().uri(accTransactionUrl).bodyValue(transactionRequest)
	                .retrieve().bodyToMono(String.class).block();
	        AcctTransactionResponse transaction = objectMapper.readValue(accTransactionResponse, AcctTransactionResponse.class);
	        System.out.println("Transaction: " + transaction);
	        String formData = "feeType=" + order.getOrderType() +
	                "&price=" + order.getPrice() +
	                "&quantity=" + order.getQuantity();
	        String feeResponse = webClientBuilder.build().post().uri("http://feeservice/fees/calculate").header("Content-Type", "application/x-www-form-urlencoded")
	                .bodyValue(formData).retrieve().bodyToMono(String.class).block();
	        FeeResponse fee = objectMapper.readValue(feeResponse, FeeResponse.class);
	        System.out.println("Fee: " + fee);
	        MarketOrderRequest marketOrderRequest = new MarketOrderRequest(order.getOrderId(), transaction.getTransactionId(), fee.getFeeId(), 500, 700, order.getOrderType());
	        String marketOrderResponse = webClientBuilder.build().post().uri("http://marketorderservice/api/marketorder")
	                .bodyValue(marketOrderRequest).retrieve().bodyToMono(String.class).block();
	        MarketOrderResponse marketOrder = objectMapper.readValue(marketOrderResponse, MarketOrderResponse.class);
	        System.out.println("Market Order: " + marketOrder);

	        model.addAttribute("transaction", transaction);
	        model.addAttribute("fee", fee);
	        model.addAttribute("marketOrder", marketOrder);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return "orderDetails";
	}
	
}