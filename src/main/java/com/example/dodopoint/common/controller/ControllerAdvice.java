package com.example.dodopoint.common.controller;

import com.example.dodopoint.common.exception.ErrorResult;
import com.example.dodopoint.common.response.ErrorResponse;
import com.example.dodopoint.store.exception.StoreErrorResult;
import com.example.dodopoint.store.exception.StoreException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ControllerAdvice {

    /* 공통 에러 */
    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResponse> handleException(final Exception exception){
        return this.makeErrorResponseEntity(ErrorResult.UNKNOWN_EXCEPTION);
    }
    private ResponseEntity<ErrorResponse> makeErrorResponseEntity(ErrorResult errorResult){
        return ResponseEntity.status(errorResult.getHttpStatus())
                .body(new ErrorResponse(errorResult.getHttpStatus().value(), errorResult.getMessage()));
    }

    private ResponseEntity<Object> makeErrorResponseEntity(String errorDescription){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), errorDescription));
    }

    /* valid 에러 */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorResponse> handleValidApiException(final MethodArgumentNotValidException exception){
        System.out.println("exception = " + exception);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getBindingResult().getAllErrors().get(0).getDefaultMessage()));
    }


    /* Store 에러 */
    @ExceptionHandler({StoreException.class})
    public ResponseEntity<ErrorResponse> handleRestApiException(final StoreException exception){
        return this.makeErrorResponseEntity(exception.getErrorResult());
    }
    private ResponseEntity<ErrorResponse> makeErrorResponseEntity(StoreErrorResult errorResult){
        return ResponseEntity.status(errorResult.getHttpStatus())
                .body(new ErrorResponse(errorResult.getHttpStatus().value(), errorResult.getMessage()));
    }
}
