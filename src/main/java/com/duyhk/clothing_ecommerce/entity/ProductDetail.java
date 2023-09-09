package com.duyhk.clothing_ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private Double priceSale;
    private Long quantity;
    private Long quantitySold;
    private Double averagedReview;

    @ManyToOne
    private Size size;

    @ManyToOne
    private Color color;

    @ManyToOne
    @JsonIgnoreProperties("productDetails")
    private Product product;

    @OneToMany(mappedBy = "productDetail")
    private List<CartDetail> cartDetails;

    @OneToMany(mappedBy = "productDetail")
    private List<BillDetail> billDetails;

    @OneToMany(mappedBy = "productDetail")
    private List<ReviewProduct> reviewProducts;

}
