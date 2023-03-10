package com.poly.users.service;

import com.poly.users.models.Account;
import com.poly.users.models.Products;

import java.util.List;

public interface AccountService {
    public List<Account> findAll();

    public Account findById(Integer id) ;

    public Account create(Account product) ;

    public Account update(Account product) ;
}
