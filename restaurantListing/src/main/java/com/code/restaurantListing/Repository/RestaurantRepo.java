package com.code.restaurantListing.Repository;

import com.code.restaurantListing.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {
}
