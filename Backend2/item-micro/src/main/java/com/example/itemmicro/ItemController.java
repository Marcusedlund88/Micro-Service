package com.example.itemmicro;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ItemController {

    ItemRepo itemRepo;

    public ItemController(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @RequestMapping("/items")
    @ResponseBody
    public List<Item> get(){
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
        Item item = itemRepo.findById(id).get();
        return item.getName();
    }
    @RequestMapping("/items/{id}/price")
    @ResponseBody
    public double getSsnById(@PathVariable long id){
        Item item = itemRepo.findById(id).get();
        return item.getPrice();
    }

    @RequestMapping("/items/new")
    @ResponseBody
    public Item createNew(@RequestBody Item item){
        return itemRepo.save(new Item(item.getName(), item.getPrice()));
    }

    @RequestMapping(value = "/items/{id}/update", method = RequestMethod.PUT)
    @ResponseBody
    public Item updateById(@PathVariable long id, @RequestBody Item updatedItem){
        Item itemToUpdate = itemRepo.findById(id).get();
        itemToUpdate.setName(updatedItem.getName());
        itemToUpdate.setPrice(updatedItem.getPrice());
        itemRepo.save(itemToUpdate);

        return itemToUpdate;
    }

    @RequestMapping(value = "/items/{id}/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteById(@PathVariable long id){
        Item item = itemRepo.findById(id).get();
        itemRepo.deleteById(id);

        return "Customer "+ item.getName() + " was deleted";
    }

}










