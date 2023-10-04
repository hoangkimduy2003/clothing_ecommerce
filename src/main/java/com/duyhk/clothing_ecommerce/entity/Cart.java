package com.duyhk.clothing_ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long totalProduct;
    private Double totalMoney;

    @OneToMany(mappedBy = "cart")
    private List<CartDetail> cartDetails;

    public Cart(Long totalProduct, Double totalMoney) {
        this.totalProduct = totalProduct;
        this.totalMoney = totalMoney;
    }
}
