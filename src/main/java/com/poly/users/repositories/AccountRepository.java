package com.poly.users.repositories;

import com.poly.users.models.Account;
import com.poly.users.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
