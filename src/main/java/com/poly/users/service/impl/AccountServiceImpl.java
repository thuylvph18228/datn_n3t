package com.poly.users.service.impl;

import com.poly.users.models.Account;
import com.poly.users.models.Products;
import com.poly.users.repositories.AccountRepository;
import com.poly.users.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public Account findById(Integer id) {
        return null;
    }

    @Override
    public Account create(Account product) {
        return null;
    }

    @Override
    public Account update(Account product) {
        return null;
    }
}
