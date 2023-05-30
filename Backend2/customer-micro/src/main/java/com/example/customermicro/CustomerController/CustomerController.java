package com.example.customermicro.CustomerController;

import com.example.customermicro.Customer.Customer;
import com.example.customermicro.CustomerRepository.CustomerRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
@CrossOrigin(origins = "http://localhost:9090")
public class CustomerController {
    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
    CustomerRepo customerRepo;

    public CustomerController(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @GetMapping("")
    @ResponseBody
    public List<Customer> getCustomers(){
        return customerRepo.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Customer getById(@PathVariable long id){

        return customerRepo.findById(id).get();
    }

    @GetMapping("/{id}/name")
    @ResponseBody
    public ResponseEntity<Object> getNameById(@PathVariable long id){
        Customer customer = customerRepo.findById(id).get();
        String name = customer.getName();

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

    @GetMapping("/{id}/ssn")
    @ResponseBody
    public ResponseEntity<Object> getSsnById(@PathVariable long id){
        Customer customer = customerRepo.findById(id).get();
        String name = customer.getSsn();

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

    @PostMapping("/new")
    @ResponseBody
    public Customer createNew(@RequestBody Customer customer){
        return customerRepo.save(new Customer(customer.getName(), customer.getSsn()));
    }

    @PutMapping(value = "/{id}/update")
    @ResponseBody
    public Customer updateById(@PathVariable long id, @RequestBody Customer updatedCustomer){
        Customer customerToUpdate = customerRepo.findById(id).get();
        customerToUpdate.setName(updatedCustomer.getName());
        customerToUpdate.setSsn(updatedCustomer.getSsn());

        customerRepo.save(customerToUpdate);
        return customerToUpdate;
    }

    @DeleteMapping(value = "/{id}/delete")
    @ResponseBody
    public String deleteById(@PathVariable long id){
        Customer customer = customerRepo.findById(id).get();
        customerRepo.deleteById(id);

        return "Customer "+ customer.getName() + " was deleted";
    }

}



