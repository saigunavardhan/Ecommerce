package com.Ecommerce.Amazon.controller;

import com.Ecommerce.Amazon.Entity.Favourites;
import com.Ecommerce.Amazon.Service.FavService;
import com.Ecommerce.Amazon.dto.FavDto;
import com.Ecommerce.Amazon.repo.FavRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/WishList")
public class FavController {
    @Autowired
    private FavService favService;
    @Autowired
    private FavRepo favRepo;

    @PostMapping("/create")
    public Favourites saveFavData(@RequestBody FavDto favDto){
        return favService.saveFav(favDto);
    }

    @GetMapping("/get")
    public List<Favourites> listFav(Favourites favourites){
        return favService.getFav(favourites);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFav(@PathVariable("id") long favId, Favourites favourites){
       favService.deleteFav(favId, favourites);
    }

}
