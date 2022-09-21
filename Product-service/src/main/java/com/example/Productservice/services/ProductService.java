package com.example.Productservice.services;


import com.example.Productservice.entity.Product;
import com.example.Productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Product saveProduct(Product prod)
    {return productRepository.save(prod);}

    public Optional<Product> findByProdId(Long prodId) {
        return productRepository.findById(prodId);
    }


}
