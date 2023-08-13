package com.cedesistemas.reactive.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Category {
    @Id
    private Integer id;
    private String name;
}
