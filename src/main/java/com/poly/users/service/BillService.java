package com.poly.users.service;

import com.poly.users.models.Bill;

import java.util.List;

public interface BillService {
    public List<Bill> findAll();

    public Bill findById(Integer id) ;

    public Bill create(Bill product) ;

    public Bill update(Bill product) ;
}
