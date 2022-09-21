package com.example.Orderservice.services;

import com.example.Orderservice.VO.Customer;
import com.example.Orderservice.VO.Product;
import com.example.Orderservice.VO.ResponseTemplate;
import com.example.Orderservice.entity.Order;
import com.example.Orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Component
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;


    public Order saveOrder(Order order) {return orderRepository.save(order);}

    public ResponseTemplate getOrderWithProductCustomer(Long odrId) {
        ResponseTemplate rtVO = new ResponseTemplate();
        Order order = orderRepository.findByOdrId(odrId);
        Product product = restTemplate.getForObject("http://localhost:3001/products/"+order.getProdId(),Product.class);
        Customer customer = restTemplate.getForObject("http://localhost:3002/customers/"+order.getCstId(),Customer.class);
        rtVO.setOrder(order);
        rtVO.setProduct(product);
        rtVO.setCustomer(customer);
        return rtVO;
    }




}
