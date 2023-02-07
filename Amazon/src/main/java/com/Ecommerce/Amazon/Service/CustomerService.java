package com.Ecommerce.Amazon.Service;

import com.Ecommerce.Amazon.Entity.Customer;
import com.Ecommerce.Amazon.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public Customer saveCustomer(Customer customer){
        return customerRepo.save(customer);
    }

    public List<Customer> listCustomer(Customer customer) {
        return customerRepo.findAll();
    }


    @Transactional
    public int deleteCustomerByCustomerId(long customerId) {
       return customerRepo.deleteByCustomerId(customerId);
    }





}
