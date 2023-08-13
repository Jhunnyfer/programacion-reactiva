package com.cedesistemas.reactive.repository;

import com.cedesistemas.reactive.model.OrderDetail;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface OrderDetailRepository extends R2dbcRepository<OrderDetail, Integer> {

    Flux<OrderDetail> findByOrderId(Integer id);

}
