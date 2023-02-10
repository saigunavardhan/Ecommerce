package com.Ecommerce.Amazon.dto;

import com.Ecommerce.Amazon.Entity.Customer;
import com.Ecommerce.Amazon.Entity.ShoppingCart;
import com.Ecommerce.Amazon.repo.ShoppingCartRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDto {
    private long id;

    private String orderStatus;

}
