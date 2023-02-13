package com.Ecommerce.Amazon.Service;


import com.Ecommerce.Amazon.Entity.Customer;
import com.Ecommerce.Amazon.Entity.Product;
import com.Ecommerce.Amazon.Entity.ShoppingCart;
import com.Ecommerce.Amazon.dto.cart.ShoppingCartDto;
import com.Ecommerce.Amazon.repo.CustomerRepo;
import com.Ecommerce.Amazon.repo.ProductRepo;
import com.Ecommerce.Amazon.repo.ShoppingCartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepo shoppingCartRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ProductService productService;


    public ShoppingCart saveCart(ShoppingCartDto shoppingCartDto) {
        ShoppingCart shoppingCart1 = shoppingCartRepo.findByCustomerCustomer_id(shoppingCartDto.getCustomerId());
        Product product = productRepo.findByProId(shoppingCartDto.getProId());
        Customer customer = customerRepo.findByCustomerId(shoppingCartDto.getCustomerId());
        if (shoppingCart1 != null) {
            List<Product> products = shoppingCart1.getProduct();
            products.add(product);
            shoppingCart1.setProduct(products);
            return shoppingCartRepo.save(shoppingCart1);
        }

        ShoppingCart shoppingCart = ShoppingCart.builder()
                .product(Arrays.asList(product))
                .customer(customer)
                .build();
        ShoppingCart save = shoppingCartRepo.save(shoppingCart);
        return save;

    }

    public List<ShoppingCart> getCart(ShoppingCart shoppingCart) {
        return shoppingCartRepo.findAll();

    }


}
