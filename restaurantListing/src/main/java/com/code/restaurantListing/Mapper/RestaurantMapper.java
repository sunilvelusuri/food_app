package com.code.restaurantListing.Mapper;

import com.code.restaurantListing.Dto.RestaurantDto;
import com.code.restaurantListing.entity.Restaurant;

public class RestaurantMapper {
    public static Restaurant mapToRestaurant(RestaurantDto restaurantDto){
        Restaurant restaurant = new Restaurant(
                restaurantDto.getId(),
                restaurantDto.getName(),
                restaurantDto.getAddress(),
                restaurantDto.getCity(),
                restaurantDto.getRestaurantDescription()
        );
    return restaurant;
    }

    public static RestaurantDto mapToRestaurantDto(Restaurant restaurant){
        RestaurantDto restaurantDto = new RestaurantDto(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getAddress(),
                restaurant.getCity(),
                restaurant.getRestaurantDescription()
        );
        return restaurantDto;
    }
}
