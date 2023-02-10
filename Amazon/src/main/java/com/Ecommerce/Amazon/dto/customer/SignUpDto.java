package com.Ecommerce.Amazon.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDto {
    private String customerName;
    private String customerEmailId;
    private String password;


}
