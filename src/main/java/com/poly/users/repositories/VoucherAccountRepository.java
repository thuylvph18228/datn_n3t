package com.poly.users.repositories;

import com.poly.users.models.VoucherAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoucherAccountRepository extends JpaRepository<VoucherAccount, Integer> {
}
