package com.example.dodopoint.store.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class StoreException extends RuntimeException{
    private final StoreErrorResult errorResult;
}
