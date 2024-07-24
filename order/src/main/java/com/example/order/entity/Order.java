package com.example.order.entity;

import com.example.order.dto.FoodItemDto;
import com.example.order.dto.RestaurantDto;
import com.example.order.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {
    private Integer orderId;
    private List<FoodItemDto> foodItemDtoList;
    private RestaurantDto restaurantDto;
    private UserDto userDto;

}
