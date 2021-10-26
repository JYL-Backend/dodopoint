package com.example.dodopoint.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BasicResponse {
    private Object data;
    private String code = "200";
    public void setData(Object obj){
        this.data = obj;
    }
}
