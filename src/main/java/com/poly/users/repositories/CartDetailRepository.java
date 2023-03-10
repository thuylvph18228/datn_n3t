package com.poly.users.repositories;

import com.poly.users.models.Cart;
import com.poly.users.models.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDetailRepository extends JpaRepository<CartDetail, Integer> {
}
