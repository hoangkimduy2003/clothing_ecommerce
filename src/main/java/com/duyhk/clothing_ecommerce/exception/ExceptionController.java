package com.duyhk.clothing_ecommerce.exception;

import com.duyhk.clothing_ecommerce.dto.ResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseDTO<Void> notFound(IllegalArgumentException e){
        return ResponseDTO.<Void>builder()
                .status(404)
                .msg("Dữ liệu không tồn tại")
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseDTO<Void> validateFail(MethodArgumentNotValidException e){
        return ResponseDTO.<Void>builder()
                .status(400)
                .msg(e.getBindingResult().getFieldError().getDefaultMessage())
                .build();
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseDTO<Void> notFound(EntityNotFoundException e){
        return ResponseDTO.<Void>builder()
                .msg(e.getMessage())
                .status(404)
                .build();
    }

}
