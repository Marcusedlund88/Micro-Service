package com.example.itemmicro.ItemController;


import com.example.itemmicro.Item.Item;
import com.example.itemmicro.ItemRepository.ItemRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/auth/items")
@CrossOrigin(origins = "http://localhost:9090")
public class ItemCustomerController {

    private static final Logger log = LoggerFactory.getLogger(ItemCustomerController.class);
    ItemRepo itemRepo;

    public ItemCustomerController(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @RequestMapping("")
    @ResponseBody
    public List<Item> get(){
        return itemRepo.findAll();
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public Item getById(@PathVariable long id){

        return itemRepo.findById(id).get();
    }

    @RequestMapping("/{id}/name")
    @ResponseBody
    public ResponseEntity<Object> getNameById(@PathVariable long id){
        Item item = itemRepo.findById(id).get();
        String name = item.getName();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonString = objectMapper.writeValueAsString(name);
            log.info(jsonString);
            return ResponseEntity.ok(jsonString);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/{id}/price")
    @ResponseBody
    public ResponseEntity<Object> getPriceById(@PathVariable long id){
        Item item = itemRepo.findById(id).get();
        double price = item.getPrice();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonString = objectMapper.writeValueAsString(price);
            log.info(jsonString);
            return ResponseEntity.ok(jsonString);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}










