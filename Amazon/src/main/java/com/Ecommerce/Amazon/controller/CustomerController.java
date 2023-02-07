package com.Ecommerce.Amazon.controller;

import com.Ecommerce.Amazon.Entity.Customer;
import com.Ecommerce.Amazon.Service.CustomerService;
import com.Ecommerce.Amazon.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepo customerRepo;

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping
    public List<Customer> listCustomer(Customer customer) {
        return customerService.listCustomer(customer);
    }

    @DeleteMapping("/{customerId}")
    public int deleteCustomerByCustomerId(@PathVariable("customerId") long customerId) {
        return customerService.deleteCustomerByCustomerId(customerId);
    }

    @PutMapping("/{customerName}")
    public Customer updateCustomer(@PathVariable String customerName, @RequestBody Customer customer){
        customer.setCustomerName(customer.getCustomerName());
        return customerService.saveCustomer(customer);
    }
    
    }
