package com.Ecommerce.Amazon.repo;


import com.Ecommerce.Amazon.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
//    Customer delete(Long customerId);

     int deleteByCustomerId(long customerId);


}

