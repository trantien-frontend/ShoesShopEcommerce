package com.project.shoesshopecommerce.utils;

import com.project.shoesshopecommerce.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
        public static <T> ResponseEntity<ApiResponse<T>> responseSuccess (T data) {
            return new ResponseEntity<ApiResponse<T>>(ApiResponse.<T>builder().body(data).build(),HttpStatus.OK);
        }
}
