package com.Ecommerce.Amazon.Service;

import com.Ecommerce.Amazon.Entity.Product;
import com.Ecommerce.Amazon.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;
    public void saveProduct(Product product) {productRepo.save(product);
    }

    public List<Product> getProduct(Product product) {
        return productRepo.findAll();
    }

    @Transactional
    public void updateById(long proId, Product product) {
        Product product1= productRepo.getById(proId);
        product1.setName(product1.getName());
        product1.setPrice(product1.getPrice());

    }

    @Transactional
    public void deleteProduct(long proId, Product product) {
        productRepo.deleteByProId(proId);

    }







}
