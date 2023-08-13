package com.cedesistemas.reactive.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Client {
    @Id
    private int id;
    private int typeId;
    private int identification;
    private String name;
    private String lastName;
    private String address;
    private int cellPhone;
}
