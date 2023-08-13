package com.cedesistemas.reactive.controller;

import com.cedesistemas.reactive.model.Category;
import com.cedesistemas.reactive.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {

    @InjectMocks
    CategoryController categoryController;

    @Mock
    CategoryService categoryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllCategories() {
        Category cat1 = new Category(1, "Test category");
        Category cat2 = new Category(2, "Test category 2");
        Flux<Category> list = Flux.just(cat1, cat2);
        when(this.categoryService.getAll()).thenReturn(list);
        Flux<Category> results = categoryController.getAllCategories();
        results.subscribe();
        assertEquals(list, results);
    }

    @Test
    void getIdCaterory() throws Exception{
        Integer id = 1;
        Category category = new Category(id, "Test category");
        when(this.categoryService.getById(any())).thenReturn(Mono.just(category));
        Mono<Category> result = categoryController.getIdCaterory(id);
        assertEquals(category, result.block());
    }

    @Test
    void saveCategory() {
        Category cat = new Category(1, "Test category");
        when(this.categoryService.save(cat)).thenReturn(Mono.just(cat));
        Mono<Category> result = categoryController.saveCategory(cat);
        assertEquals(cat, result);
    }

    @Test
    void updateClient() {
        Category cat = new Category(1, "Test category");
        when(this.categoryService.update(1, cat)).thenReturn(Mono.just(cat));
        Mono<Category> result = categoryController.updateCategory(1, cat);
        StepVerifier.create(result)
                .expectNext(cat)
                .verifyComplete();
    }
}