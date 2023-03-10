package com.poly.users.service;

import com.poly.users.models.Origin;

import java.util.List;

public interface OriginService {
    public List<Origin> findAll();

    public Origin findById(Integer id) ;

    public Origin create(Origin product) ;

    public Origin update(Origin product) ;
}
