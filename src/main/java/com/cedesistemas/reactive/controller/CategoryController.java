package com.cedesistemas.reactive.controller;


import com.cedesistemas.reactive.model.Category;
import com.cedesistemas.reactive.model.Client;
import com.cedesistemas.reactive.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public Flux<Category> getAllCategories(){
        return  categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Category> getIdCaterory(@PathVariable Integer id){
        return categoryService.getById(id);
    }

    @PostMapping("/")
    public Mono<Category> saveCategory(@RequestBody Category category){
        return categoryService.save(category);
    }

    @PutMapping("/{id}")
    public Mono<Category> updateClient(@PathVariable Integer id, @RequestBody Category category){
        return categoryService.update(id, category);
    }

}
