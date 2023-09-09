package com.duyhk.clothing_ecommerce.controller;

import com.duyhk.clothing_ecommerce.dto.BillDTO;
import com.duyhk.clothing_ecommerce.dto.PageDTO;
import com.duyhk.clothing_ecommerce.dto.PageRequestDTO;
import com.duyhk.clothing_ecommerce.dto.ResponseDTO;
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
    public ResponseDTO<PageDTO<List<BillDTO>>> getAll(@RequestBody PageRequestDTO pageRequestDTO) {
        return ResponseDTO.<PageDTO<List<BillDTO>>>builder()
                .data(billService.getAll(pageRequestDTO))
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
    public ResponseDTO<Void> create(@RequestBody BillDTO billDTO){
        billService.create(billDTO);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Tạo hoá đơn thành công")
                .build();
    }
    @PutMapping("/{id}")
    public ResponseDTO<Void> update(@RequestBody BillDTO billDTO,
                                    @PathVariable Long id){
        billDTO.setId(id);
        billService.update(billDTO);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Sửa hoá đơn thành công")
                .build();
    }
    @DeleteMapping("/{id}")
    public ResponseDTO<Void> deleteById(@PathVariable Long id){
        billService.delete(id);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Xoá hoá đơn thành công")
                .build();
    }
}
