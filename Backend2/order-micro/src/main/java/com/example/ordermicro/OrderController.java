package com.example.ordermicro;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    OrderRepo orderRepo;

    public OrderController(OrderRepo orderRepo){
        this.orderRepo = orderRepo;
    }
    private static final Logger log = LoggerFactory.getLogger(OrderController.class);
    @RequestMapping("/orders")
    @ResponseBody
    public List<Orders> getOrders(){
        return orderRepo.findAll();
    }

    @RequestMapping("/orders/info/{id}")
    @ResponseBody
    public String customerNameByOrderId(@PathVariable long id){
        // Create a RestTemplate instance
        log.info("ok");
        RestTemplate restTemplate = new RestTemplate();

        // Make the API call to retrieve the username
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/customers/{id}/name", HttpMethod.GET, null, String.class, id);
        log.info(response.toString());
        // Retrieve the username from the response
        String username = response.getBody();
        log.info(username);
        // Return the username or perform any other necessary operations
        return username;
    }
}









