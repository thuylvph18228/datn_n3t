package com.poly.users.service;

import com.poly.users.models.BillProduct;

import java.util.List;

public interface BillProductService {
    public List<BillProduct> findAll();

    public BillProduct findById(Integer id) ;

    public BillProduct create(BillProduct product) ;

    public BillProduct update(BillProduct product) ;
}
