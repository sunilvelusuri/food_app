package com.code.restaurantListing.service.impll;

import com.code.restaurantListing.Dto.RestaurantDto;
import com.code.restaurantListing.Repository.RestaurantRepo;
import com.code.restaurantListing.entity.Restaurant;
import com.code.restaurantListing.service.RestaurantService;
import com.code.restaurantListing.Mapper.RestaurantMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private RestaurantRepo restaurantRepo;
    @Override
    public RestaurantDto addRestaurant(RestaurantDto restaurantDto) {
        Restaurant savedRestaurant = restaurantRepo.save(RestaurantMapper.mapToRestaurant(restaurantDto));
        return RestaurantMapper.mapToRestaurantDto(savedRestaurant);
    }

    @Override
    public ResponseEntity<RestaurantDto> fetchRestaurantById(Integer id) {
        Optional<Restaurant> restaurant = restaurantRepo.findById(id);
        if (restaurant.isPresent()){
            return new ResponseEntity<>(RestaurantMapper.mapToRestaurantDto(restaurant.get()),HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<RestaurantDto> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepo.findAll();
        List<RestaurantDto> allRestaurants = restaurants.stream().map(RestaurantMapper::mapToRestaurantDto).collect(Collectors.toList());
//        List<RestaurantDto> allRestaurants = restaurants.stream().map( restaurant -> RestaurantMapper.mapToRestaurantDto(restaurant)).collect(Collectors.toList());
        return allRestaurants;
    }
}
