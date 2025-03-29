package com.example.asssignment.service;

import org.springframework.stereotype.Service;

import com.example.asssignment.model.User;
import com.example.asssignment.repository.UserRepository;

import reactor.core.publisher.Mono;

@Service
public class UserService {

	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	public Mono<User> saveUser(User user) {
		return userRepository.save(user);
	}
	
	public Mono<User> getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public Mono<User> getUser(String userId) {
		return userRepository.findById(userId);
	}
	
}
