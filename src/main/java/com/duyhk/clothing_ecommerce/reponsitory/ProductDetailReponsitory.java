package com.duyhk.clothing_ecommerce.reponsitory;

import com.duyhk.clothing_ecommerce.entity.BillDetail;
import com.duyhk.clothing_ecommerce.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailReponsitory extends JpaRepository<ProductDetail, Long> {
}
