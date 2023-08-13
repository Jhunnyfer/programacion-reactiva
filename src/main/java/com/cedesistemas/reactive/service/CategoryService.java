package com.cedesistemas.reactive.service;

import com.cedesistemas.reactive.model.Category;
import com.cedesistemas.reactive.model.Client;
import com.cedesistemas.reactive.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CategoryService {
    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Mono<Category> save(Category category){
        return categoryRepository.save(category);
    }

    public Mono<Category> update(Integer id, Category category){
        category.setId(id);
        return categoryRepository.save(category);
    }

    public Flux<Category> getAll(){
        return categoryRepository.findAll();
    }

    public Mono<Category> getById(Integer id){
        return categoryRepository.findById(id);
    }
}
