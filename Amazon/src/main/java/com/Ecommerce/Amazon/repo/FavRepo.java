package com.Ecommerce.Amazon.repo;

import com.Ecommerce.Amazon.Entity.Favourites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavRepo extends JpaRepository<Favourites, Long>{

}
