package com.cedesistemas.reactive.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
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
