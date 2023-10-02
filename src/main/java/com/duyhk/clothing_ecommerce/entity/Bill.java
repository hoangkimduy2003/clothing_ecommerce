package com.duyhk.clothing_ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Bill extends TimeAuditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String billCode;
    private String note;
    private Long tatolProduct;
    private Double totalMoney;
    private Integer status;
    private Date orderDate;
    private Date orderDateFinal;
    @ManyToOne
    private Address address;

    @ManyToOne
    private Users user;

    @OneToMany(mappedBy = "bill")
    private List<BillDetail> billDetails;

}
