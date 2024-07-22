package com.code.restaurantListing.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
public class RestaurantDto {

    private Long id;
    private String name;
    private String address;
    private String city;
    private String restaurantDescription;

}
