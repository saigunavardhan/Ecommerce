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
    public ResponseEntity<ApiResponse> saveProduct(@RequestBody Product product){
        productService.saveProduct(product);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Success"), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Product> getProduct(@RequestBody Product product) {
        return productService.getProduct(product);

    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("id") long proId,@RequestBody Product product){
        productService.updateById(proId, product);
        productService.saveProduct(product);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Success"), HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable("id") long proId,@RequestBody Product product){
        productService.deleteProduct(proId, product);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Success"), HttpStatus.OK);
    }

}

