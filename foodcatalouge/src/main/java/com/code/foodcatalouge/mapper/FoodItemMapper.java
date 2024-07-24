package com.code.foodcatalouge.mapper;

import com.code.foodcatalouge.dto.FoodItemDto;
import com.code.foodcatalouge.entity.FoodItem;

public class FoodItemMapper {

    public static FoodItem mapFoodItemDtoToFoodItem(FoodItemDto foodItemDto){
        FoodItem foodItem = new FoodItem(
                foodItemDto.getId(),
                foodItemDto.getItemName(),
                foodItemDto.getItemDescription(),
                foodItemDto.isVeg(),
                foodItemDto.getPrice(),
                foodItemDto.getRestaurantId(),
                foodItemDto.getQuantity()
        );
        return foodItem;
    }

    public static FoodItemDto mapFoodItemToFoodItemDto(FoodItem foodItem){
        FoodItemDto foodItemDto = new FoodItemDto(
                foodItem.getId(),
                foodItem.getItemName(),
                foodItem.getItemDescription(),
                foodItem.isVeg(),
                foodItem.getPrice(),
                foodItem.getRestaurantId(),
                foodItem.getQuantity()
        );
        return foodItemDto;
    }
}
