package com.Ecommerce.Amazon.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Orders {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    private Long orderId;
    private String orderDescription;
    @OneToOne(mappedBy = "orders")
    private ShoppingCart shoppingCart;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "orders")
    private List<OrderItem> orderItems;
}

