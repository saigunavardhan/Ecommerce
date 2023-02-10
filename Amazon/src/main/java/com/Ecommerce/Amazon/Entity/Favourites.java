package com.Ecommerce.Amazon.Entity;




import lombok.*;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Favourites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long favId;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Product.class)
    @JoinColumn(nullable = false, name ="pro_id")
    private Product product;




}