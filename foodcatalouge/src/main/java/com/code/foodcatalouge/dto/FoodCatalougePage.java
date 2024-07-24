package com.code.foodcatalouge.dto;

import com.code.foodcatalouge.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCatalougePage {

    private List<FoodItem> foodItemList;
    private Restaurant restaurant;
}
