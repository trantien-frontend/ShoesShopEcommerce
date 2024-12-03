package com.project.shoesshopecommerce.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppException extends RuntimeException {
    ErrorCode errorCode;

    public AppException(ErrorCode _errorCode) {
        super(_errorCode.getMessage());
        this.errorCode = _errorCode;
    }
}
