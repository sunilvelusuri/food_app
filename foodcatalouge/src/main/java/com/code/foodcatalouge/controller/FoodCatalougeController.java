package com.code.foodcatalouge.controller;

import com.code.foodcatalouge.dto.FoodCatalougePage;
import com.code.foodcatalouge.dto.FoodItemDto;
import com.code.foodcatalouge.service.FoodCatalougeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/foodCatalouge")
@AllArgsConstructor
public class FoodCatalougeController {

    private FoodCatalougeService foodCatalougeService;

    @GetMapping("/{restaurantId}")
    public ResponseEntity<FoodCatalougePage> fetchRestaurantWithFoodMenu(@PathVariable Integer restaurantId){
        FoodCatalougePage foodCatalougePage = foodCatalougeService.fetchFoodCatalougePageDetails(restaurantId);
        return new ResponseEntity<>(foodCatalougePage, HttpStatus.OK);
    }

    @PostMapping("/addFoodItem")
    public ResponseEntity<FoodItemDto> addFoodItem(@RequestBody FoodItemDto foodItemDto){
        return new ResponseEntity<>(foodCatalougeService.addFoodItem(foodItemDto), HttpStatus.CREATED);
    }


}
