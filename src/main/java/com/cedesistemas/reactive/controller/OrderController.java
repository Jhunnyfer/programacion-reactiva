package com.cedesistemas.reactive.controller;

import com.cedesistemas.reactive.model.Client;
import com.cedesistemas.reactive.model.OrderDetail;
import com.cedesistemas.reactive.model.Orders;
import com.cedesistemas.reactive.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/{id}")
    public Mono<Orders> getIdOrder(@PathVariable Integer id){
        return orderService.findById(id);
    }

    @PostMapping("/")
    public Mono<Orders> saveOrder(@RequestBody Orders order){
        return orderService.saveOrder(order);
    }

    @PostMapping("/order-detail")
    public Flux<OrderDetail> saveOrderDetail(@RequestBody List<OrderDetail> orderDetails){
        return orderService.saveOrderDetail(orderDetails);
    }

    @GetMapping("/order-detail/{id}")
    public Flux<OrderDetail> getOrderDetailById(@PathVariable Integer id){
        return orderService.findByOrderDetailId(id);
    }

}
