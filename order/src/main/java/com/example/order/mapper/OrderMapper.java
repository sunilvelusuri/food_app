package com.example.order.mapper;

import com.example.order.dto.OrderDto;
import com.example.order.entity.Order;

public class OrderMapper {
    public static Order mapOrderDtoToOrder(OrderDto orderDto){
        Order order = new Order(
                orderDto.getOrderId(),
                orderDto.getFoodItemDtoList(),
                orderDto.getRestaurantDto(),
                orderDto.getUserDto()
        );
    return order;
    }

    public static OrderDto mapOrderToOrderDto(Order order){
        OrderDto orderDto = new OrderDto(
                order.getOrderId(),
                order.getFoodItemDtoList(),
                order.getRestaurantDto(),
                order.getUserDto()
        );
        return orderDto;
    }

}
