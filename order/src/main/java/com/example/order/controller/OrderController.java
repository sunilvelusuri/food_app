package com.example.order.controller;

import com.example.order.dto.OrderDto;
import com.example.order.dto.OrderDtoFromFE;
import com.example.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping("/api/order")
public class OrderController {
    private OrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDto> saveOrder(@RequestBody OrderDtoFromFE orderDetails){
        OrderDto savedOrderDto = orderService.saveOrderInDb(orderDetails);
        System.out.println(savedOrderDto);
        return new ResponseEntity<>(savedOrderDto, HttpStatus.CREATED);
    }
}
