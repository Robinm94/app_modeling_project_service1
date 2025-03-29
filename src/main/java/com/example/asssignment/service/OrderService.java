package com.example.asssignment.service;

import org.springframework.stereotype.Service;

import com.example.asssignment.model.Order;
import com.example.asssignment.repository.OrderRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderService {

	private OrderRepository orderRepository;
	
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	public Mono<Order> saveOrder(Order order) {
		return orderRepository.save(order);
	}
	
	public Flux<Order> getOrdersByUserId(String userId) {
		return orderRepository.findByUserId(userId);
	}
	
	public Mono<Order> getOrder(String orderId) {
		return orderRepository.findById(orderId);
	}
}
