package com.poly.users.repositories;

import com.poly.users.models.Cart;
import com.poly.users.models.Colors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Colors, Integer> {
}
