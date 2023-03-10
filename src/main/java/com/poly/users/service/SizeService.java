package com.poly.users.service;

import com.poly.users.models.Sizes;

import java.util.List;

public interface SizeService {
    public List<Sizes> findAll();

    public Sizes findById(Integer id) ;

    public Sizes create(Sizes product) ;

    public Sizes update(Sizes product) ;
}
