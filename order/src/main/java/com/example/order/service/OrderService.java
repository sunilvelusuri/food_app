package com.example.order.service;

import com.example.order.dto.OrderDto;
import com.example.order.dto.OrderDtoFromFE;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {


    OrderDto saveOrderInDb(OrderDtoFromFE orderDetails);
}
