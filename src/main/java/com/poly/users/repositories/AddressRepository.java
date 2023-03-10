package com.poly.users.repositories;

import com.poly.users.models.Address;
import com.poly.users.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
