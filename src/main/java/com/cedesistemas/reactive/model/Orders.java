package com.cedesistemas.reactive.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.lang.annotation.Annotation;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Orders {
    @Id
    private Integer id;
    private Integer clientId;
    private Integer qty;
    private Double totalOrder;
    private LocalDateTime dateOrder;
    @Transient
    private List<OrderDetail> orderDetail;
}
