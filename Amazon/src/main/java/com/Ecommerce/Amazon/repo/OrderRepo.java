package com.Ecommerce.Amazon.repo;


import com.Ecommerce.Amazon.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Long> {
    Orders getById(long orderId);


}
