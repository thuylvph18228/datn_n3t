package com.poly.users.service;

import com.poly.users.models.Colors;

import java.util.List;

public interface ColorService {
    public List<Colors> findAll();

    public Colors findById(Integer id) ;

    public Colors create(Colors product) ;

    public Colors update(Colors product) ;
}
