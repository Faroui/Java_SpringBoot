package com.farouishop.orderservice.controller;
import com.farouishop.orderservice.dtos.OrderRequest;
import com.farouishop.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void placeOrder(@RequestBody OrderRequest orderRequest){
        orderService.placeOrder(orderRequest);
    }
}
