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

    @PostMapping
    public ResponseEntity<ApiResponse> saveCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return new ResponseEntity<>(new ApiResponse(true, "Created Successfully"), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> listCustomer(@RequestBody Customer customer) {
        customerService.listCustomer(customer);
        return new ResponseEntity<>(new ApiResponse(true, "Fetched Successfully"),HttpStatus.FOUND);
    }

    @DeleteMapping("/{customerId}")
    public int deleteCustomerByCustomerId(@PathVariable("customerId") long customerId) {
        return customerService.deleteCustomerByCustomerId(customerId);
    }

    @PutMapping("/{customerId}")
    public String updateCustomer(@PathVariable("customerId") long customerId, @RequestBody Customer customer){
        customerService.editCustomer(customerId, customer);
        customerService.saveCustomer(customer);
        return "Success";

    }


    @PostMapping("/signUp")
    public ResponseDto signUp(@RequestBody SignUpDto signUpDto){
        return customerService.signUp(signUpDto);
    }

    @PostMapping("/signIn")
    public SignInResponseDto signIn(@RequestBody SignInDto signInDto){
        return customerService.signIn(signInDto);
    }





    }
