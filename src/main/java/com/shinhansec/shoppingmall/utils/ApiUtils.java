package com.shinhansec.shoppingmall.utils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

public class ApiUtils {
    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<>(true, data, null, null);
    }

    public static <T> ApiResult<T> error(T data, String message, HttpStatus httpStatus) {
        return new ApiResult<>(false, data, new ApiError(message, httpStatus), null);
    }

    @Getter
    @AllArgsConstructor
    public static class ApiResult<T> {
        boolean success;
        T response;
        ApiError error;
        String message;
    }

    @Getter
    static class ApiError {
        String message;
        HttpStatus httpStatus;

        ApiError(String message, HttpStatus httpStatus) {
            this.message = message;
            this.httpStatus = httpStatus;
        }
    }
}
