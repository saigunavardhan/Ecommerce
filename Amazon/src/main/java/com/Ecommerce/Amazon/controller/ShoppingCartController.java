package com.Ecommerce.Amazon.controller;


import com.Ecommerce.Amazon.Entity.ShoppingCart;
import com.Ecommerce.Amazon.Service.ShoppingCartService;
import com.Ecommerce.Amazon.common.ApiResponse;
import com.Ecommerce.Amazon.dto.cart.ShoppingCartDto;
import com.Ecommerce.Amazon.repo.CustomerRepo;
import com.Ecommerce.Amazon.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ProductRepo productRepo;

    @PostMapping("/create")
    public ShoppingCart saveShoppingCart(@RequestBody ShoppingCartDto shoppingCartDto){
        ShoppingCart shoppingCart = shoppingCartService.saveCart(shoppingCartDto);
        return shoppingCart;
    }
    @GetMapping("/get")
    public List<ShoppingCart> listCart( ShoppingCart shoppingCart){
       return shoppingCartService.getCart(shoppingCart);
    }


}
