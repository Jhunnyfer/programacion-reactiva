package com.cedesistemas.reactive.repository;

import com.cedesistemas.reactive.model.Client;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface ClientRepository extends R2dbcRepository<Client, Integer> {
}
