package com.poly.users.service;

import com.poly.users.models.CartDetail;

import java.util.List;

public interface CartDetalService {
    public List<CartDetail> findAll();

    public CartDetail findById(Integer id) ;

    public CartDetail create(CartDetail product) ;

    public CartDetail update(CartDetail product) ;
}
