package com.poly.users.service.impl;

import com.poly.users.models.Sizes;
import com.poly.users.models.Vouchers;
import com.poly.users.repositories.VoucherRepository;
import com.poly.users.service.SizeService;
import com.poly.users.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeServiceImpl implements SizeService {

    @Override
    public List<Sizes> findAll() {
        return null;
    }

    @Override
    public Sizes findById(Integer id) {
        return null;
    }

    @Override
    public Sizes create(Sizes product) {
        return null;
    }

    @Override
    public Sizes update(Sizes product) {
        return null;
    }
}
