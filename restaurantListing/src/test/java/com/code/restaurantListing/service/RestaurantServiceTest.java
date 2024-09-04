package com.code.restaurantListing.service;

import com.code.restaurantListing.Dto.RestaurantDto;
import com.code.restaurantListing.Mapper.RestaurantMapper;
import com.code.restaurantListing.Repository.RestaurantRepo;
import com.code.restaurantListing.entity.Restaurant;
import com.code.restaurantListing.service.impll.RestaurantServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RestaurantServiceTest {

    @InjectMocks
    RestaurantServiceImpl restaurantService;

    @Mock
    RestaurantRepo restaurantRepo;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllRestaurants(){
        List<Restaurant> mockRestaurants = Arrays.asList(
                new Restaurant(1L, "Restaurant 1", "Address 1", "city 1", "Desc 1"),
                new Restaurant(2L, "Restaurant 2", "Address 2", "city 2", "Desc 2")
        );
        when(restaurantRepo.findAll()).thenReturn(mockRestaurants);

        List<RestaurantDto> restaurantDtoList = restaurantService.getAllRestaurants();

        assertEquals(mockRestaurants.size(), restaurantDtoList.size());
        for (int i = 0; i < mockRestaurants.size(); i++){
            RestaurantDto expectedDto = RestaurantMapper.mapToRestaurantDto(mockRestaurants.get(i));
            assertEquals(expectedDto, restaurantDtoList.get(i));
        }

        verify(restaurantRepo,times(1)).findAll();
    }

    @Test
    public void testAddRestaurant(){
        RestaurantDto mockRestaurantDto = new RestaurantDto(1L, "Restaurant 1", "Address 1", "city 1", "Desc 1");
        Restaurant mockRestaurant = RestaurantMapper.mapToRestaurant(mockRestaurantDto);
        when(restaurantRepo.save(mockRestaurant)).thenReturn(mockRestaurant);

        RestaurantDto savedRestaurantDto = restaurantService.addRestaurant(mockRestaurantDto);

        assertEquals(mockRestaurantDto, savedRestaurantDto);

        verify(restaurantRepo,times(1)).save(mockRestaurant);
    }

    @Test
    public void testFetchRestaurantById(){
        Integer id = 1;
        Long Lid = 1L;
        Restaurant mockRestaurant = new Restaurant(1L, "Restaurant 1", "Address 1", "city 1", "Desc 1");
        when(restaurantRepo.findById(id)).thenReturn(Optional.of(mockRestaurant));

        ResponseEntity<RestaurantDto> response = restaurantService.fetchRestaurantById(id);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals((Lid), response.getBody().getId());
        verify(restaurantRepo, times(1)).findById(id);
    }

    @Test
    public void testFetchRestaurantById_NotExistingId(){
        Integer id = 1;
        when(restaurantRepo.findById(id)).thenReturn(Optional.empty());

        ResponseEntity<RestaurantDto> response = restaurantService.fetchRestaurantById(id);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(null, response.getBody());
        verify(restaurantRepo, times(1)).findById(id);
    }
}
