package com.poly.users.repositories;

import com.poly.users.models.Bill;
import com.poly.users.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Integer> {
}
