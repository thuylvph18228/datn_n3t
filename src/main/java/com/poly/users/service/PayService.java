package com.poly.users.service;

import com.poly.users.models.Pay;

import java.util.List;

public interface PayService {
    public List<Pay> findAll();

    public Pay findById(Integer id) ;

    public Pay create(Pay product) ;

    public Pay update(Pay product) ;
}
