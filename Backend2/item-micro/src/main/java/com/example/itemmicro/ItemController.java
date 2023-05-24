package com.example.itemmicro;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ItemController {

    ItemRepo itemRepo;

    public ItemController(ItemRepo itemRepo){
        this.itemRepo = itemRepo;
    }

    @RequestMapping("/items")
    @ResponseBody
    public List<Item> getItems(){
        return itemRepo.findAll();
    }

    @RequestMapping("/items/{id}")
    @ResponseBody
    public Item getById(@PathVariable long id){
        return itemRepo.findById(id).get();
    }
    @RequestMapping("/items/{id}/name")
    @ResponseBody
    public String getNameById(@PathVariable long id){
        Item item =itemRepo.findById(id).get();
        return item.getName();
    }
    @RequestMapping("/items/{id}/price")
    @ResponseBody
    public double getPriceById(@PathVariable long id){
        Item item =itemRepo.findById(id).get();
        return item.getPrice();
    }
}










