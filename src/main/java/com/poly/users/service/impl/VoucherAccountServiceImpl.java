package com.poly.users.service.impl;

import com.poly.users.models.VoucherAccount;
import com.poly.users.models.Vouchers;
import com.poly.users.repositories.VoucherAccountRepository;
import com.poly.users.repositories.VoucherRepository;
import com.poly.users.service.VoucherAccountService;
import com.poly.users.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoucherAccountServiceImpl implements VoucherAccountService {

    @Autowired
    VoucherAccountRepository voucherAccountRepository;

    @Override
    public List<VoucherAccount> findAll() {
        return null;
    }

    @Override
    public VoucherAccount findById(Integer id) {
        return null;
    }

    @Override
    public VoucherAccount create(VoucherAccount product) {
        return null;
    }

    @Override
    public VoucherAccount update(VoucherAccount product) {
        return null;
    }
}
