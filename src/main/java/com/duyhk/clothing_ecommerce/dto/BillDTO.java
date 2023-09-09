package com.duyhk.clothing_ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillDTO extends TimeAuditableDTO{
    private Long id;

    private String note;
    private Long tatolProduct;
    private Double totalMoney;
    private Integer status;
    private Date orderDate;
    private Date orderDateFinal;
    private AddressDTO address;
    private UserDTO user;
    private List<BillDetailDTO> billDetails;
}
