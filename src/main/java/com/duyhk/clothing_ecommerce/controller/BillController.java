package com.duyhk.clothing_ecommerce.controller;

import com.duyhk.clothing_ecommerce.dto.*;
import com.duyhk.clothing_ecommerce.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private BillService billService;

    @GetMapping("")
    public ResponseDTO<List<BillDTO>> getAll() {
        return ResponseDTO.<List<BillDTO>>builder()
                .data(billService.getAll())
                .status(200)
                .build();
    }

    @PostMapping("/page")
    public ResponseDTO<PageDTO<List<BillDTO>>> getByPageRequest(@RequestBody(required = false) PageRequestDTO pageRequestDTO) {
        return ResponseDTO.<PageDTO<List<BillDTO>>>builder()
                .data(billService.getByPageRequest(pageRequestDTO == null ? new PageRequestDTO() : pageRequestDTO))
                .status(200)
                .build();
    }

    @GetMapping("/{id}")
    public ResponseDTO<BillDTO> getById(@PathVariable Long id) {
        return ResponseDTO.<BillDTO>builder()
                .status(200)
                .data(billService.getById(id))
                .build();
    }

    @PostMapping("")
    public ResponseDTO<Void> create(@RequestBody BillDTO billDTO) {
        billService.create(billDTO);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Tạo hoá đơn thành công")
                .build();
    }

    @PutMapping("/{id}")
    public ResponseDTO<Void> update(@RequestBody BillDTO billDTO,
                                    @PathVariable Long id) {
        billDTO.setId(id);
        billService.update(billDTO);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Sửa hoá đơn thành công")
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseDTO<Void> deleteById(@PathVariable Long id) {
        billService.delete(id);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Xoá hoá đơn thành công")
                .build();
    }
}
