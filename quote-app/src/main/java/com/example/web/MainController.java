package com.example.web;

import com.example.domain.UserRepository;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	private final UserRepository userRepository;

	public MainController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/quotes")
	public String quotes() {
		return "quotes";
	}

}
