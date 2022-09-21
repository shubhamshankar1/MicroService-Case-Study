package com.example.Orderservice.controller;


import com.example.Orderservice.VO.ResponseTemplate;
import com.example.Orderservice.entity.Order;
import com.example.Orderservice.repository.OrderRepository;
import com.example.Orderservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/")
    public Order saveOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @GetMapping("/{id}")
    public ResponseTemplate getOrderWithProductCustomer(@PathVariable("id") Long prodId, Long cstId) {
        return orderService.getOrderWithProductCustomer(prodId);

    }
    @PutMapping("/update_orders/{id}")
    public ResponseEntity<Order> updateOrderWithProductCustomer(@PathVariable("id") long id, @RequestBody Order order)
    {

        Optional<Order> OrderData = orderRepository.findById(id);
        if (OrderData.isPresent()) {
            Order _order = OrderData.get();
            _order.setOrder_number(order.getOrder_number());
            _order.setOrder_status(order.getOrder_status());

            return new ResponseEntity<>(orderRepository.save(_order), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete_orders/{id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("id") long id){
        try {
            orderRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception ex) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
