package com.poly.users.service;

import com.poly.users.models.Vouchers;

import java.util.List;

public interface VoucherService {
    public List<Vouchers> findAll();

    public Vouchers findById(Integer id) ;

    public Vouchers create(Vouchers product) ;

    public Vouchers update(Vouchers product) ;

    void delete(Integer id);
}
