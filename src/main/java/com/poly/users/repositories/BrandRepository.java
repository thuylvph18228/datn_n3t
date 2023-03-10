package com.poly.users.repositories;

import com.poly.users.models.Brand;
import com.poly.users.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
