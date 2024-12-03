package com.project.shoesshopecommerce.exception;

import com.project.shoesshopecommerce.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = AppException.class)
    public ResponseEntity<ApiResponse> handlerAppException (AppException appException) {
        ErrorCode errorCode = appException.getErrorCode();
        ApiResponse apiResponse = ApiResponse.builder().message(errorCode.getMessage()).code(errorCode.getCode()).build();
        return new ResponseEntity<>(apiResponse, errorCode.getStatusCode());
    }
}
