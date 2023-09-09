package com.duyhk.clothing_ecommerce.reponsitory;

import com.duyhk.clothing_ecommerce.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressReponsitory extends JpaRepository<Address, Long> {
}
