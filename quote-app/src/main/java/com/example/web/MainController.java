package com.example.web;

import com.example.domain.UserRepository;
import reactor.core.publisher.Flux;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
public class MainController {

	private final UserRepository userRepository;

	private final WebClient webClient;

	private final Flux<Quote> quotesFeed;

	public MainController(UserRepository userRepository) {
		this.userRepository = userRepository;
		this.webClient = WebClient.create("http://localhost:8081");
		this.quotesFeed = this.webClient.get()
				.uri("/quotes")
				.accept(MediaType.APPLICATION_STREAM_JSON)
				.retrieve()
				.bodyToFlux(Quote.class)
				.share()
				.log();
	}

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("users", this.userRepository.findAll());
		return "index";
	}

	@GetMapping("/quotes")
	public String quotes() {
		return "quotes";
	}

	@GetMapping(path = "/quotes/feed", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	@ResponseBody
	public Flux<Quote> fetchQuotesStream() {
		return quotesFeed;
	}

}
