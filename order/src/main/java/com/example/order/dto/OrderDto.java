package com.example.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Integer orderId;
    private List<FoodItemDto> foodItemDtoList;
    private RestaurantDto restaurantDto;
    private UserDto userDto;
}
