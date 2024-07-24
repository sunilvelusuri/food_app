package com.code.foodcatalouge.service.impl;

import com.code.foodcatalouge.dto.FoodCatalougePage;
import com.code.foodcatalouge.dto.FoodItemDto;
import com.code.foodcatalouge.dto.Restaurant;
import com.code.foodcatalouge.entity.FoodItem;
import com.code.foodcatalouge.mapper.FoodItemMapper;
import com.code.foodcatalouge.repository.FoodItemRepository;
import com.code.foodcatalouge.service.FoodCatalougeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class FoodCatalougeServiceImpl implements FoodCatalougeService{
    private FoodItemRepository foodItemRepository;

    public FoodCatalougeServiceImpl(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    @Autowired
    RestTemplate restTemplate;

    @Override
    public FoodItemDto addFoodItem(FoodItemDto foodItemDto) {
        FoodItem savedFoodItem = foodItemRepository.save(FoodItemMapper.mapFoodItemDtoToFoodItem(foodItemDto));
        return FoodItemMapper.mapFoodItemToFoodItemDto(savedFoodItem);
    }

    @Override
    public FoodCatalougePage fetchFoodCatalougePageDetails(Integer restaurantId) {
        List<FoodItem> foodItemList =  fetchFoodItemList(restaurantId);
        Restaurant restaurant = fetchRestaurantFromRestaurantMS(restaurantId);
        return createFoodCatalougePage(foodItemList, restaurant);
    }

    private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
        System.out.println("In private method id : " + restaurantId);
        return foodItemRepository.findByRestaurantId(restaurantId);
    }

    private Restaurant fetchRestaurantFromRestaurantMS(Integer restaurantId) {
        return restTemplate.getForObject("http://RESTAURANT-SERVICE/api/restaurant/fetchById/" + restaurantId, Restaurant.class);
    }


    private FoodCatalougePage createFoodCatalougePage(List<FoodItem> foodItemList, Restaurant restaurant) {
        FoodCatalougePage foodCatalougePage = new FoodCatalougePage();
        foodCatalougePage.setFoodItemList(foodItemList);
        foodCatalougePage.setRestaurant(restaurant);
        return foodCatalougePage;
    }
}
