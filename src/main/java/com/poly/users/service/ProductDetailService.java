package com.poly.users.service;

import com.poly.users.models.ProductDetail;

import java.util.List;

public interface ProductDetailService {
    public List<ProductDetail> findAll();

    public ProductDetail findById(Integer id) ;

    public ProductDetail create(ProductDetail product) ;

    public ProductDetail update(ProductDetail product) ;
}
