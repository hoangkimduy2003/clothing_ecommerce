package com.duyhk.clothing_ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double maximumPromotion;
    private Double promotionalLevel;
    private Date dateStart;
    private Date dateEnd;
    private Long quantity;
    private Integer status;

    @OneToMany(mappedBy = "voucher")
    private List<VoucherDetail> voucherDetails;

    @OneToMany(mappedBy = "voucher")
    private List<Bill> bills;

}
