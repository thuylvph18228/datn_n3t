package com.poly.users.repositories;

import com.poly.users.models.Cart;
import com.poly.users.models.Pay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayRepository extends JpaRepository<Pay, Integer> {
}
