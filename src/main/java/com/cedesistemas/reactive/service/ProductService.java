package com.cedesistemas.reactive.service;

import com.cedesistemas.reactive.model.Product;
import com.cedesistemas.reactive.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class ProductService {
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Flux<Product> findAll() {
        return productRepository.findAll();
    }

    public Mono<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    public Mono<Product> save(Product product) {
        if (validations(product)) {
            return productRepository.save(product);
        }
        return Mono.empty();
    }

    public Mono<Product> update(Integer id, Product product) {
        if (validations(product)) {
            return productRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
                    .flatMap(o -> {
                                if (o.isPresent()) {
                                    product.setId(id);
                                    return productRepository.save(product);
                                }
                                return Mono.empty();
                            });
        }
        return Mono.empty();
    }

    public Mono<Product> deleteById(Integer id) {
        return productRepository.findById(id).flatMap(product ->productRepository.deleteById(product.getId()).thenReturn(product));
    }

    public Mono<Void> deleteAll() {
        return productRepository.deleteAll();
    }

    private Boolean validations(Product product) {
        if (product.getQty() < 0 || product.getUnitPrice() < 0) {
            return false;
        }
        return true;
    }
}
