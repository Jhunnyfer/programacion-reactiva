package com.cedesistemas.reactive.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Category {
    @Id
    private Integer id;
    private String name;
}
