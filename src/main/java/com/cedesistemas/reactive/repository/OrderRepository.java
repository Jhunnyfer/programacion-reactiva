package com.cedesistemas.reactive.repository;

import com.cedesistemas.reactive.model.Orders;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface OrderRepository extends R2dbcRepository<Orders, Integer> {
}
