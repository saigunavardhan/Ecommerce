package com.Ecommerce.Amazon.repo;

import com.Ecommerce.Amazon.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{


   long deleteByProId(long proId);

   Product findByProId(long proId);


}
