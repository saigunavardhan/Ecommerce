package com.Ecommerce.Amazon.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Or;

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
    @Column(name ="pro_id")
    private long proId;
    private String name;
    private float price;





    @JsonIgnore
    @ManyToMany(mappedBy = "product")
    private List<ShoppingCart> shoppingCarts;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<Favourites> favourites;



}
