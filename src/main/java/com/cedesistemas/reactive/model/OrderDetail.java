package com.cedesistemas.reactive.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class OrderDetail {
    @Id
    private Integer id;
    private Integer orderId;
    private Integer productId;
    private Integer qty;
    private Integer unitPrice;
    private Double total;

}
