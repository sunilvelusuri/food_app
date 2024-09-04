package com.code.foodcatalouge.controller;

import com.code.foodcatalouge.service.impl.FoodCatalougeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class FoodCatalougeControllerTest {

    @InjectMocks
    private FoodCatalougeController foodCatalougeController;

    @Mock
    private FoodCatalougeServiceImpl foodCatalougeService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }


}
