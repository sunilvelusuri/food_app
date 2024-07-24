package com.code.foodcatalouge.service;

import com.code.foodcatalouge.dto.FoodCatalougePage;
import com.code.foodcatalouge.dto.FoodItemDto;
import org.springframework.stereotype.Service;

@Service
public interface FoodCatalougeService {
    FoodItemDto addFoodItem(FoodItemDto foodItemDto);

    FoodCatalougePage fetchFoodCatalougePageDetails(Integer restaurantId);
}
