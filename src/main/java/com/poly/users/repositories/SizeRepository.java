package com.poly.users.repositories;

import com.poly.users.models.Cart;
import com.poly.users.models.Sizes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeRepository extends JpaRepository<Sizes, Integer> {
}
