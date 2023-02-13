package com.Ecommerce.Amazon.Service;


import com.Ecommerce.Amazon.Entity.Customer;
import com.Ecommerce.Amazon.Entity.Orders;
import com.Ecommerce.Amazon.Entity.Product;
import com.Ecommerce.Amazon.Entity.ShoppingCart;
import com.Ecommerce.Amazon.dto.OrderDto;
import com.Ecommerce.Amazon.repo.CustomerRepo;
import com.Ecommerce.Amazon.repo.OrderRepo;
import com.Ecommerce.Amazon.repo.ProductRepo;
import com.Ecommerce.Amazon.repo.ShoppingCartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ShoppingCartRepo shoppingCartRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CustomerRepo customerRepo;


    public Orders saveOrder(OrderDto orderDto) {
        ShoppingCart shoppingCart = shoppingCartRepo.findById(orderDto.getId()).get();
        Orders orders = Orders.builder()
                .shoppingCart(shoppingCart).orderStatus(orderDto.getOrderStatus()).build();
        Orders save = orderRepo.save(orders);
        return save;
    }


    @Transactional
    public void updateStatus(long orderId, Orders orders, OrderDto orderDto){
        Orders orders1 = orderRepo.getById(orderId);
        orders1.setOrderStatus(orderDto.getOrderStatus());
        orderRepo.save(orders1);
    }

    private OrderDto convertEntityToDto(Orders orders){
        OrderDto orderDto = new OrderDto();
        orderDto.setId(orderDto.getId());
        return orderDto;
    }

}

