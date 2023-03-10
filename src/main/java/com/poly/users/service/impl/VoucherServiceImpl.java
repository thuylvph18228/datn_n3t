package com.poly.users.service.impl;

import com.poly.users.models.Vouchers;
import com.poly.users.repositories.VoucherRepository;
import com.poly.users.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoucherServiceImpl implements VoucherService {

    @Autowired
    VoucherRepository voucherRepository;


    @Override
    public List<Vouchers> findAll() {
        return voucherRepository.findAll();
    }

    @Override
    public Vouchers findById(Integer id) {
        return null;
    }

    @Override
    public Vouchers create(Vouchers product) {
        return null;
    }

    @Override
    public Vouchers update(Vouchers product) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
