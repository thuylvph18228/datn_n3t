package com.poly.users.service;

import com.poly.users.models.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> findAll();

    public Category findById(Integer id) ;

    public Category create(Category product) ;

    public Category update(Category product) ;
}
