package com.example.Orderservice.VO;


import com.example.Orderservice.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplate {

    private Order order;
    private Product product;
    private Customer customer;

}
