package com.poly.users.service;

import com.poly.users.models.VoucherAccount;

import java.util.List;

public interface VoucherAccountService {
    public List<VoucherAccount> findAll();

    public VoucherAccount findById(Integer id) ;

    public VoucherAccount create(VoucherAccount product) ;

    public VoucherAccount update(VoucherAccount product) ;
}
