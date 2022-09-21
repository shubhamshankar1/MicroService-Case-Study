package com.example.Orderservice.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long odrId;

    @Column(name = "order_number")
    private Long order_number;

    @Column(name = "order_status")
    private String order_status;

    private Long prodId;

    private Long cstId;
}
