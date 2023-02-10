package com.Ecommerce.Amazon.dto.cart;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ShoppingCartDto {
    private long proId;
    private long customerId;
    private int quantity;


}
