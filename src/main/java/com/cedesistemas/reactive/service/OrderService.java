package com.cedesistemas.reactive.service;

import com.cedesistemas.reactive.model.OrderDetail;
import com.cedesistemas.reactive.model.Orders;
import com.cedesistemas.reactive.model.Product;
import com.cedesistemas.reactive.repository.OrderDetailRepository;
import com.cedesistemas.reactive.repository.OrderRepository;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    OrderRepository orderRepository;
    OrderDetailRepository orderDetailRepository;

    public OrderService(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
    }

    public Mono<Orders> saveOrder(Orders order){
        order.setDateOrder(LocalDateTime.now());
        return orderRepository.save(order);
    }

    public Mono<Orders> findById(Integer id) {
        return orderRepository.findById(id);
    }

    public Flux<OrderDetail> saveOrderDetail(List<OrderDetail> orderDetails){
        return orderDetailRepository.saveAll(orderDetails);
    }

    public Flux<OrderDetail> findByOrderDetailId(Integer id) {
        return orderDetailRepository.findByOrderId(id);
    }


}
