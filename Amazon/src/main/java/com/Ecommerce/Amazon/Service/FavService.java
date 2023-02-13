package com.Ecommerce.Amazon.Service;

import com.Ecommerce.Amazon.Entity.Customer;
import com.Ecommerce.Amazon.Entity.Favourites;
import com.Ecommerce.Amazon.Entity.Product;
import com.Ecommerce.Amazon.dto.FavDto;
import com.Ecommerce.Amazon.repo.CustomerRepo;
import com.Ecommerce.Amazon.repo.FavRepo;
import com.Ecommerce.Amazon.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FavService {
    @Autowired
    private FavRepo favRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CustomerRepo customerRepo;

    public Favourites saveFav(FavDto favDto){
        Product product = productRepo.findByProId(favDto.getProId());
        Customer customer = customerRepo.findByCustomerId(favDto.getCustomerId());
        Favourites favourites = Favourites.builder().product(product).customer(customer).build();
        Favourites save = favRepo.save(favourites);
        return save;
    }

    public List<Favourites> getFav(Favourites favourites) {
        List<Favourites> all = favRepo.findAll();
        return all;
    }

    @Transactional
    public void deleteFav(long favId, Favourites favourites){
        favRepo.deleteByFavId(favId);
    }
}

