package com.duyhk.clothing_ecommerce.exception;

import com.duyhk.clothing_ecommerce.dto.ResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.PropertyNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController extends RuntimeException{

//    public ExceptionController(String message) {
//        super(message);
//    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseDTO<Void> notFound(IllegalArgumentException e){
        return ResponseDTO.<Void>builder()
                .status(404)
                .msg(e.getMessage())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseDTO<Void> validateFail(MethodArgumentNotValidException e){
        return ResponseDTO.<Void>builder()
                .status(400)
                .msg(e.getBindingResult().getFieldError().getDefaultMessage())
                .build();
    }

    @ExceptionHandler(PropertyNotFoundException.class)
    public ResponseDTO<Void> notFound(PropertyNotFoundException e){
        return ResponseDTO.<Void>builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .msg(e.getMessage())
                .build();
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseDTO<Void> notFound(EntityNotFoundException e){
        return ResponseDTO.<Void>builder()
                .msg(e.getMessage())
                .status(404)
                .build();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseDTO<Void> notFound(HttpMessageNotReadableException e){
        return ResponseDTO.<Void>builder()
                .msg(e.getMessage())
                .status(400)
                .build();
    }

}
