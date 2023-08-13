package com.cedesistemas.reactive.repository;

import com.cedesistemas.reactive.model.Product;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ProductRepository  extends R2dbcRepository<Product, Integer> {
    Flux<Product> findByNameContaining(String name);
    Flux<Product> findByStatus(Boolean status);
}
