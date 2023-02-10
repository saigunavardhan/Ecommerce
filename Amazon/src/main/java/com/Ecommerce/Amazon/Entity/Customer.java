package com.Ecommerce.Amazon.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

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


    private String password;


    public Customer(String customerName, String customerEmailId, String encryptedPassword) {
        this.customerName = customerName;
        this.customerEmailId = customerEmailId;
        this.password = encryptedPassword;
    }
}
