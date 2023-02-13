package com.Ecommerce.Amazon.Service;

import com.Ecommerce.Amazon.Entity.Customer;
import com.Ecommerce.Amazon.dto.ResponseDto;
import com.Ecommerce.Amazon.dto.customer.SignInDto;
import com.Ecommerce.Amazon.dto.customer.SignUpDto;
import com.Ecommerce.Amazon.dto.customer.SignInResponseDto;
import com.Ecommerce.Amazon.exceptions.CustomException;
import com.Ecommerce.Amazon.exceptions.AuthenticationFailException;
import com.Ecommerce.Amazon.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

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


    @Transactional
    public void editCustomer(long customerId, Customer customer){
        Customer customer1 = customerRepo.getById(customerId);
        customer1.setCustomerName(customer1.getCustomerName());
        customer1.setCustomerEmailId(customer1.getCustomerEmailId());
    }

    @Transactional
    public Customer signUp(SignUpDto signUpDto) {
        if(Objects.nonNull(customerRepo.findByCustomerEmailId(signUpDto.getCustomerEmailId()))){
            throw new CustomException("user already present");
        }

        Customer customer = new Customer(signUpDto.getCustomerName(), signUpDto.getCustomerEmailId(), signUpDto.getPassword());
        return customerRepo.save(customer);


//        ResponseDto responseDto = new ResponseDto("success", "user created successfully");
//        return responseDto;

    }

    @Transactional
    public SignInResponseDto signIn(SignInDto signInDto) {

        Customer customer = customerRepo.findByCustomerEmailId(signInDto.getCustomerEmailId
                ());

        if (!customer.getPassword().equals(signInDto.getPassword())){
            throw new AuthenticationFailException("Incorrect credentials");
        }

        return new SignInResponseDto("success");
    }
}
