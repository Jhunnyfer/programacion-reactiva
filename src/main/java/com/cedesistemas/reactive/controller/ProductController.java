package com.cedesistemas.reactive.controller;

import com.cedesistemas.reactive.model.Product;
import com.cedesistemas.reactive.repository.ProductRepository;
import com.cedesistemas.reactive.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/{id}")
    public Mono<Product> getProductById(@PathVariable Integer id){
        return productService.findById(id);
    }
    
    @GetMapping("/")
    public Flux<Product> getAllProducts(){
        return productService.findAll();
    }

    @PostMapping("/")
    public Mono<Product> createProduct(@RequestBody Product product){
        return productService.save(product);
    }

    @PutMapping("/{id}")
    public Mono<Product> updateProduct(@PathVariable Integer id, @RequestBody Product product){
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public Mono<Product> deleteProductById(@PathVariable Integer id){
        return productService.deleteById(id);
    }

    @DeleteMapping("/")
    public Mono<Void> deleteProductAll(){
        return productService.deleteAll();
    }
}
