package com.poly.users.service;

import com.poly.users.models.Brand;

import java.util.List;

public interface BrandService {
    public List<Brand> findAll();

    public Brand findById(Integer id) ;

    public Brand create(Brand product) ;

    public Brand update(Brand product) ;
}
