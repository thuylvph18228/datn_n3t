package com.poly.users.repositories;

import com.poly.users.models.Cart;
import com.poly.users.models.Vouchers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoucherRepository extends JpaRepository<Vouchers, Integer> {
}
