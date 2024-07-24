package com.example.order.service.impl;

import com.example.order.dto.OrderDto;
import com.example.order.dto.OrderDtoFromFE;
import com.example.order.dto.UserDto;
import com.example.order.entity.Order;
import com.example.order.mapper.OrderMapper;
import com.example.order.service.OrderService;
import com.example.order.repository.OrderRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;
    public OrderServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }
    @Autowired
    SequenceGenerator sequenceGenerator;
    @Autowired
    RestTemplate restTemplate;

    @Override
    public OrderDto saveOrderInDb(OrderDtoFromFE orderDetails) {
        Integer newOrderId = sequenceGenerator.generateNextOrderId();
        UserDto userDto = fetchUserDetailsFromUserId(orderDetails.getUserId());
        Order orderToBeSaved = new Order(newOrderId, orderDetails.getFoodItemDtoList(), orderDetails.getRestaurantDto(), userDto);
        orderRepo.save(orderToBeSaved);
        return OrderMapper.mapOrderToOrderDto(orderToBeSaved);
    }

    private UserDto fetchUserDetailsFromUserId(Integer userId) {
        return restTemplate.getForObject("http://USER-SERVICE/api/user/fetchUserById/" + userId, UserDto.class);
    }
}
