package com.example.ordermicro;

import com.example.ordermicro.Orders.Orders;
import com.example.ordermicro.OrdersRepository.OrderRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class OrderMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderMicroApplication.class, args);
	}
	@Bean
	public CommandLineRunner orders (OrderRepo orderRepo) {
		return (args) -> {
			List<Long> list1 = new ArrayList<>();
			List<Long> list2 = new ArrayList<>();
			List<Long> list3 = new ArrayList<>();

			list1.add(1L);
			list2.add(1L);
			list3.add(2L);
			orderRepo.save(new Orders(1,list1));

			orderRepo.save(new Orders(2,list2));
			orderRepo.save(new Orders(3,list3));

		};
	}
}
