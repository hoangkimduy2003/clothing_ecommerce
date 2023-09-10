package com.duyhk.clothing_ecommerce.controller;

import com.duyhk.clothing_ecommerce.dto.*;
import com.duyhk.clothing_ecommerce.service.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/billDetail")
public class BillDetailController {
    @Autowired
    private BillDetailService billDetailService;
    @GetMapping("")
    public ResponseDTO<List<BillDetailDTO>> getAll(){
        return ResponseDTO.<List<BillDetailDTO>>builder()
                .data(billDetailService.getAll())
                .status(200)
                .build();
    }
    @PostMapping("/page")
    public ResponseDTO<PageDTO<List<BillDetailDTO>>> getByPageRequest(@RequestBody(required = false) PageRequestDTO pageRequestDTO) {
        return ResponseDTO.<PageDTO<List<BillDetailDTO>>>builder()
                .data(billDetailService.getByPageRequest(pageRequestDTO == null ? new PageRequestDTO() : pageRequestDTO))
                .status(200)
                .build();
    }

    @PostMapping("/{id}")
    public ResponseDTO<BillDetailDTO> getById(@PathVariable Long id) {
        return ResponseDTO.<BillDetailDTO>builder()
                .status(200)
                .data(billDetailService.getById(id))
                .build();
    }
    @PostMapping("")
    public ResponseDTO<Void> create(@RequestBody BillDetailDTO billDetailDTO){
        billDetailService.create(billDetailDTO);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Tạo hoá đơn chi tiết thành công")
                .build();
    }
    @PutMapping("/{id}")
    public ResponseDTO<Void> update(@RequestBody BillDetailDTO billDetailDTO,
                                    @PathVariable Long id){
        billDetailDTO.setId(id);
        billDetailService.update(billDetailDTO);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Sửa hoá đơn chi tiết thành công")
                .build();
    }
    @DeleteMapping("/{id}")
    public ResponseDTO<Void> deleteById(@PathVariable Long id){
        billDetailService.delete(id);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Xoá hoá đơn chi tiết thành công")
                .build();
    }
}
