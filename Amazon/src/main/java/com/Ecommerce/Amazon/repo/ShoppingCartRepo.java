package com.Ecommerce.Amazon.repo;

import com.Ecommerce.Amazon.Entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepo extends JpaRepository<ShoppingCart, Long> {


@Query(value = "SELECT * FROM shopping_cart WHERE customer_id = ?1",
nativeQuery = true)
ShoppingCart findByCustomerCustomer_id(long customerId);
}
