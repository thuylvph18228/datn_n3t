package com.poly.users.repositories;

import com.poly.users.models.BillProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillProductRepository extends JpaRepository<BillProduct, Integer> {
}
