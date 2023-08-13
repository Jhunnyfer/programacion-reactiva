package com.cedesistemas.reactive.repository;

import com.cedesistemas.reactive.model.Category;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface CategoryRepository extends R2dbcRepository<Category, Integer> {
}
