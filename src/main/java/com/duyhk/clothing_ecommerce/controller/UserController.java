package com.duyhk.clothing_ecommerce.controller;

import com.duyhk.clothing_ecommerce.dto.PageDTO;
import com.duyhk.clothing_ecommerce.dto.PageRequestDTO;
import com.duyhk.clothing_ecommerce.dto.ResponseDTO;
import com.duyhk.clothing_ecommerce.dto.UserDTO;
import com.duyhk.clothing_ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseDTO<List<UserDTO>> getAll(){
        return ResponseDTO.<List<UserDTO>>builder()
                .data(userService.getAll())
                .status(200)
                .build();
    }
    @PostMapping("/page")
    public ResponseDTO<PageDTO<List<UserDTO>>> getByPageRequest(@RequestBody(required = false) PageRequestDTO pageRequestDTO) {
        return ResponseDTO.<PageDTO<List<UserDTO>>>builder()
                .data(userService.getByPageRequest(pageRequestDTO == null ? new PageRequestDTO() : pageRequestDTO))
                .status(200)
                .build();
    }

    @GetMapping("/{id}")
    public ResponseDTO<UserDTO> getById(@PathVariable Long id) {
        return ResponseDTO.<UserDTO>builder()
                .status(200)
                .data(userService.getById(id))
                .build();
    }

    @PostMapping("")
    public ResponseDTO<Void> create(@RequestBody UserDTO userDTO) {
        userService.create(userDTO);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Thêm kích cỡ phẩm thành công")
                .build();
    }

    @PutMapping("/{id}")
    public ResponseDTO<Void> update(@RequestBody UserDTO userDTO,
                                    @PathVariable Long id) {
        userDTO.setId(id);
        userService.update(userDTO);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Sửa kích cỡ phẩm thành công")
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseDTO<Void> deleteById(@PathVariable Long id) {
        userService.delete(id);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("Xoá kích cỡ phẩm thành công")
                .build();
    }
}
