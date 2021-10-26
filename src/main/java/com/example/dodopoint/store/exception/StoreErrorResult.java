package com.example.dodopoint.store.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum StoreErrorResult {
    EMPTY_STORE_NAME(HttpStatus.BAD_REQUEST, "가게명이 누락되었습니다."),
    ISSET_STORE_NAME(HttpStatus.BAD_REQUEST, "이미 존재하는 가게명입니다."),
    NOT_FOUND_STORE(HttpStatus.BAD_REQUEST, "가게를 찾을 수 없습니다."),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
