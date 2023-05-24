package com.example.customermicro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {

    CustomerRepo customerRepo;

    public CustomerController(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @RequestMapping("/customers")
    @ResponseBody
    public List<Customer> getCustomers(){
        return customerRepo.findAll();
    }

    @RequestMapping("/customers/{id}")
    @ResponseBody
    public Customer getById(@PathVariable long id){

        return customerRepo.findById(id).get();
    }

    @RequestMapping("/customers/{id}/name")
    @ResponseBody
    public String getNameById(@PathVariable long id){
        Customer customer = customerRepo.findById(id).get();
        return customer.getName();
    }
    @RequestMapping("/customers/{id}/ssn")
    @ResponseBody
    public String getSsnById(@PathVariable long id){
        Customer customer = customerRepo.findById(id).get();
        return customer.getSsn();
    }

    @RequestMapping("/customers/new")
    @ResponseBody
    public Customer createNew(@RequestBody Customer customer){
        return customerRepo.save(new Customer(customer.getName(), customer.getSsn()));
    }

    @RequestMapping(value = "/customers/{id}/update", method = RequestMethod.PUT)
    @ResponseBody
    public Customer updateById(@PathVariable long id, @RequestBody Customer updatedCustomer){
        Customer customerToUpdate = customerRepo.findById(id).get();
        customerToUpdate.setName(updatedCustomer.getName());
        customerToUpdate.setSsn(updatedCustomer.getSsn());

        return customerToUpdate;
    }

    @RequestMapping(value = "/customers/{id}/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteById(@PathVariable long id){
        Customer customer = customerRepo.findById(id).get();
        customerRepo.deleteById(id);

        return "Customer "+ customer.getName() + " was deleted";
    }

}



