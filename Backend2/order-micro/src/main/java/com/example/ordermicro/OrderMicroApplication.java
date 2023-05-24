package com.example.ordermicro;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrderMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderMicroApplication.class, args);
	}
	@Bean
	public CommandLineRunner orders (OrderRepo orderRepo) {
		return (args) -> {
			orderRepo.save(new Orders(1,1));
			orderRepo.save(new Orders(2,2));
			orderRepo.save(new Orders(3,3));

		};
	}
}
