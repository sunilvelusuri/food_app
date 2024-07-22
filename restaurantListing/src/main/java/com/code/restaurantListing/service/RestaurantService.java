package com.code.restaurantListing.service;

import com.code.restaurantListing.Dto.RestaurantDto;
import com.code.restaurantListing.entity.Restaurant;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RestaurantService {

    List<RestaurantDto> getAllRestaurants();
    RestaurantDto addRestaurant(RestaurantDto restaurantDto);
    ResponseEntity<RestaurantDto> fetchRestaurantById(Integer id);
}
