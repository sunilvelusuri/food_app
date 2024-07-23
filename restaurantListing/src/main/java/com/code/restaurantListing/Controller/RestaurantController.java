package com.code.restaurantListing.Controller;

import com.code.restaurantListing.Dto.RestaurantDto;
import com.code.restaurantListing.service.RestaurantService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
//@AllArgsConstructor
public class RestaurantController {
    private RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }


    @GetMapping("/getAllRestaurants")
    public ResponseEntity<List<RestaurantDto>> getAllRestaurants(){
        return new ResponseEntity<>(restaurantService.getAllRestaurants(),HttpStatus.OK);
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDto> addRestaurant(@RequestBody RestaurantDto restaurantDto){
        System.out.println(restaurantDto);
        return new ResponseEntity<>(restaurantService.addRestaurant(restaurantDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDto> fetchById(@PathVariable Integer id){
         return restaurantService.fetchRestaurantById(id);
    }
}
