package com.Ecommerce.Amazon.Entity;


import com.Ecommerce.Amazon.dto.cart.ShoppingCartDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShoppingCart {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany(cascade = CascadeType.ALL, targetEntity = Product.class)
    @JoinTable(name = "Cart_Product")
    private List<Product> product;

    @JsonIgnore
    @OneToOne(mappedBy = "shoppingCart")
    private Orders orders;


}

