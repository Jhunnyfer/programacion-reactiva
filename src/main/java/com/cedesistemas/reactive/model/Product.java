package com.cedesistemas.reactive.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Product {
     @Id
    private Integer id;
    private String name;
    private String description;
    private Integer qty;
    private Double unitPrice;
    private Integer categoryId;
    private Boolean status;
}
