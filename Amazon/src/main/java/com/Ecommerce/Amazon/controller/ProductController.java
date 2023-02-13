package com.Ecommerce.Amazon.controller;

import com.Ecommerce.Amazon.Entity.Customer;
import com.Ecommerce.Amazon.Entity.Product;
import com.Ecommerce.Amazon.Service.ProductService;
import com.Ecommerce.Amazon.common.ApiResponse;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);

    }
    @GetMapping("/get")
    public List<Product> getProduct(Product product) {
        return productService.getProduct(product);

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("id") long proId,@RequestBody Product product){
        productService.updateById(proId, product);
        productService.saveProduct(product);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Success"), HttpStatus.OK);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable("id") long proId, Product product){
        productService.deleteProduct(proId, product);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Success"), HttpStatus.OK);
    }

}

