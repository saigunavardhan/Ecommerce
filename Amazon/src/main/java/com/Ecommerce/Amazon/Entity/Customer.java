package com.Ecommerce.Amazon.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(
        name = "tbl_Customer",
        uniqueConstraints = @UniqueConstraint(
                name = "emailId_unq",
                columnNames = "customer_emailId"
        )
)
public class Customer {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long customerId;
    private String customerName;

    @Column(
            name = "customer_emailId"
    )
    private String customerEmailId;

    @JsonIgnore
    @OneToOne(mappedBy = "customer")
    private ShoppingCart shoppingCart;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Orders> orders;

}
