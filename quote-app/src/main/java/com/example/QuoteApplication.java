package com.example;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import com.example.domain.User;
import com.example.domain.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QuoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuoteApplication.class, args);
	}

	@Bean
	public CommandLineRunner createUsers(UserRepository userRepository) {
		return strings -> {
			List<User> users = Arrays.asList(
					new User("sdeleuze", "Sebastien Deleuze"),
					new User("bclozel", "Brian Clozel"),
					new User("rstoyanchev", "Rossen Stoyanchev"),
					new User("smaldini", "Stephane Maldini"),
					new User("sbasle", "Simon Basle"),
					new User("snicoll", "Stephane Nicoll")
			);
			userRepository.saveAll(users).blockLast(Duration.ofSeconds(3));
		};
	}

}
