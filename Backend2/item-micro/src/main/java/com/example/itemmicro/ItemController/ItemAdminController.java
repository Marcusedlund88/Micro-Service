package com.example.itemmicro.ItemController;

import com.example.itemmicro.Item.Item;
import com.example.itemmicro.ItemRepository.ItemRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
@CrossOrigin(origins = "http://localhost:9090")
public class ItemAdminController {

    private static final Logger log = LoggerFactory.getLogger(ItemCustomerController.class);
    ItemRepo itemRepo;

    public ItemAdminController(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }



    @RequestMapping("/new")
    @ResponseBody
    public Item createNew(@RequestBody Item item){
        return itemRepo.save(new Item(item.getName(), item.getPrice()));
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.PUT)
    @ResponseBody
    public Item updateById(@PathVariable long id, @RequestBody Item updatedItem){
        Item itemToUpdate = itemRepo.findById(id).get();
        itemToUpdate.setName(updatedItem.getName());
        itemToUpdate.setPrice(updatedItem.getPrice());
        itemRepo.save(itemToUpdate);
        return itemToUpdate;
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteById(@PathVariable long id){
        Item item = itemRepo.findById(id).get();
        itemRepo.deleteById(id);

        return "Customer "+ item.getName() + " was deleted";
    }

}