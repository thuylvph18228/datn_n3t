package com.poly.users.service;

import com.poly.users.models.Products;

import java.util.List;

public interface ProductService {
    public List<Products> findAll();

    public Products findById(Integer id) ;

    public Products create(Products product) ;

    public Products update(Products product) ;

    public void delete(Integer id) ;
}
