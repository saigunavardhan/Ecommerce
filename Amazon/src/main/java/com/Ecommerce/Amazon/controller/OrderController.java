package com.Ecommerce.Amazon.controller;

import com.Ecommerce.Amazon.Entity.Orders;
import com.Ecommerce.Amazon.Service.OrderService;
import com.Ecommerce.Amazon.common.ApiResponse;
import com.Ecommerce.Amazon.dto.OrderDto;
import com.Ecommerce.Amazon.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> saveOrder(@RequestBody OrderDto orderDto){
         orderService.saveOrder(orderDto);
         return new ResponseEntity<>(new ApiResponse(true, "Order Placed"), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateOrderStatus(@PathVariable("id") long orderId, @RequestBody OrderDto orderDto , Orders orders){
        orderService.updateStatus(orderId, orders, orderDto);
        return new ResponseEntity<>(new ApiResponse(true, "Your order is approved and on its way"), HttpStatus.CREATED);
    }

}
