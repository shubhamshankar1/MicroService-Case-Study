package com.example.Orderservice.VO;


import lombok.*;

import javax.persistence.Column;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

    private Long prodId;

    @Column(name = "prodName")
    private String prodName;

    @Column(name = "prodQty")
    private String prodQty;

    @Column(name = "prodCost")
    private Long prodCost;
}
