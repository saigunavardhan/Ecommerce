package com.Ecommerce.Amazon.repo;


import com.Ecommerce.Amazon.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {


     int deleteByCustomerId(long customerId);

    Customer findByCustomerId(long customerId);

    Customer findByCustomerEmailId(String customerEmailId);
}

