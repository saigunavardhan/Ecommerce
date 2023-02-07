package com.Ecommerce.Amazon.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder

public class Product {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long proId;
    private String name;
    private int quantity;
    private float price;

    @ManyToMany(mappedBy = "products")
    private List<OrderItem> orderItems;

}
