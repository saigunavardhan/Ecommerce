package com.Ecommerce.Amazon.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "order_details")
@Builder
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = ShoppingCart.class)
    @JoinColumn(name = "id", nullable = false)
    private ShoppingCart shoppingCart;

    private String orderStatus;



}
