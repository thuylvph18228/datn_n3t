package com.poly.users.service.impl;

import com.poly.users.models.Products;
import com.poly.users.repositories.ProductRepository;
import com.poly.users.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;


    @Override
    public List<Products> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Products findById(Integer id) {
        return null;
    }

    @Override
    public Products create(Products product) {
        return null;
    }

    @Override
    public Products update(Products product) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
