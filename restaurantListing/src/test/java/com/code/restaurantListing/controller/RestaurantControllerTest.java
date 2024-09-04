package com.code.restaurantListing.controller;

import com.code.restaurantListing.Controller.RestaurantController;
import com.code.restaurantListing.Dto.RestaurantDto;
import com.code.restaurantListing.entity.Restaurant;
import com.code.restaurantListing.service.RestaurantService;
import com.code.restaurantListing.service.impll.RestaurantServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class RestaurantControllerTest {

    @InjectMocks
    RestaurantController restaurantController;

    @Mock
    RestaurantService restaurantService;


    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testGetAllRestaurants() {

        List<RestaurantDto> mockRestaurants = Arrays.asList(
                new RestaurantDto(1L, "Restaurant 1", "Address 1", "city 1", "Desc 1"),
                new RestaurantDto(2L, "Restaurant 2", "Address 2", "city 2", "Desc 2")
        );
        when(restaurantService.getAllRestaurants()).thenReturn(mockRestaurants);

        ResponseEntity<List<RestaurantDto>> response = restaurantController.getAllRestaurants();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockRestaurants, response.getBody());

        verify(restaurantService,times(1)).getAllRestaurants();
    }

    @Test
    public void testAddRestaurant(){
        RestaurantDto restaurantDto = new RestaurantDto(1L, "Restaurant 1", "Address 1", "city 1", "Desc 1");
        when(restaurantService.addRestaurant(restaurantDto)).thenReturn(restaurantDto);

        ResponseEntity<RestaurantDto> response = restaurantController.addRestaurant(restaurantDto);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(restaurantDto, response.getBody());

        verify(restaurantService,times(1)).addRestaurant(restaurantDto);
    }

    @Test
    public void testFetchById(){
        Integer id = 1;
        RestaurantDto restaurantDtoById = new RestaurantDto(9L, "Restaurant 1", "Address 1", "city 1", "Desc 1");
        when(restaurantService.fetchRestaurantById(id)).thenReturn(new ResponseEntity<>(restaurantDtoById, HttpStatus.OK));

        ResponseEntity<RestaurantDto> response = restaurantController.fetchById(id);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(restaurantDtoById, response.getBody());
        verify(restaurantService,times(1)).fetchRestaurantById(id);
    }
}




