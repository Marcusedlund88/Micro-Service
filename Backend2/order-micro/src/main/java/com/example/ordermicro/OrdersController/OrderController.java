package com.example.ordermicro.OrdersController;

import com.example.ordermicro.OrdersRepository.OrderRepo;
import com.example.ordermicro.Orders.Orders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/auth/orders")
@CrossOrigin(origins = "http://localhost:9090")
public class OrderController {

    OrderRepo orderRepo;

    public OrderController(OrderRepo orderRepo){
        this.orderRepo = orderRepo;
    }
    private static final Logger log = LoggerFactory.getLogger(OrderController.class);
    @GetMapping("")
    @ResponseBody
    public List<Orders> getOrders(){
        return orderRepo.findAll();
    }

    @GetMapping("/info/{id}")
    @ResponseBody
    public String customerNameByOrderId(@PathVariable long id){

        Orders orderToVerify = orderRepo.findById(id).get();
        Long customerId = orderToVerify.getCustomerId();

        log.info("ok");
        RestTemplate restTemplate = new RestTemplate();


        ResponseEntity<String> responseCustomer = restTemplate.exchange(
                "http://gateway-micro:8080/customers/{customerId}/name",
                HttpMethod.GET,
                null,
                String.class,
                customerId
        );
        log.info(responseCustomer.toString());

        String username = responseCustomer.getBody();

        List<String> itemsToEvaluate = new ArrayList<>();

        orderToVerify.getItemIds().forEach(item->{
            ResponseEntity<String> responseItem = restTemplate.exchange(
                    "http://gateway-micro:8080/items/{item}/name",
                    HttpMethod.GET,
                    null,
                    String.class,
                    item
            );
            log.info(responseItem.toString());

            String itemName = responseItem.getBody();
            itemsToEvaluate.add(itemName);
        });

        log.info(username);

        return username + " " + itemsToEvaluate.toString();
    }
    @PostMapping("/new")
    @ResponseBody
    public Orders makeNewOrder(@RequestBody Orders orders){

        Orders order = new Orders(orders.getCustomerId(), orders.getItemIds());
        orderRepo.save(order);
        return order;
    }

    @PutMapping("/{id}/update")
    @ResponseBody
    public Orders updateOrder(@PathVariable long id){
         Orders orderToUpdate = orderRepo.findById(id).get();
         return orderToUpdate;
    }
}









