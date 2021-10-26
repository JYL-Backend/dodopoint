package com.example.dodopoint.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorResult {
    UNKNOWN_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "알수없는 에러가 발생하였습니다."),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
