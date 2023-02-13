package com.Ecommerce.Amazon.controller;

import com.Ecommerce.Amazon.Entity.Customer;
import com.Ecommerce.Amazon.Service.CustomerService;
import com.Ecommerce.Amazon.common.ApiResponse;
import com.Ecommerce.Amazon.dto.ResponseDto;
import com.Ecommerce.Amazon.dto.customer.SignInDto;
import com.Ecommerce.Amazon.dto.customer.SignInResponseDto;
import com.Ecommerce.Amazon.dto.customer.SignUpDto;
import com.Ecommerce.Amazon.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepo customerRepo;

    @PostMapping("/create")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return  customerService.saveCustomer(customer);
    }

    @GetMapping("/get")
    public List<Customer> listCustomer(Customer customer) {
        List <Customer> customers= customerService.listCustomer(customer);
        return customers;
    }

    @DeleteMapping("/delete/{customerId}")
    public int deleteCustomerByCustomerId(@PathVariable("customerId") long customerId) {
        return customerService.deleteCustomerByCustomerId(customerId);
    }

    @PutMapping("/update/{customerId}")
    public String updateCustomer(@PathVariable("customerId") long customerId, @RequestBody Customer customer){
        customerService.editCustomer(customerId, customer);
        customerService.saveCustomer(customer);
        return "Success";

    }


    @PostMapping("/signUp")
    public Customer signUp(@RequestBody SignUpDto signUpDto){
        return customerService.signUp(signUpDto);
    }

    @PostMapping("/signIn")
    public SignInResponseDto signIn(@RequestBody SignInDto signInDto){
        return customerService.signIn(signInDto);
    }





    }
