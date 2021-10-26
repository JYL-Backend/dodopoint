package com.example.dodopoint.store.dto;

import com.example.dodopoint.common.validation.ValidationGroup;
import com.example.dodopoint.store.domain.entity.StoreEntity;
import com.example.dodopoint.store.domain.value.Address;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
public class ResponseStoreDTO {

    private String storeName;
    private String phoneNumber;
    private String address;
    private String zipCode;
    private Long id;

    static public ResponseStoreDTO getResponseStoreDTO(StoreEntity entity){
        return ResponseStoreDTO.builder()
                .storeName(entity.getStoreName())
                .address(entity.getAddress().getAddress())
                .zipCode(entity.getAddress().getZipCode())
                .phoneNumber(entity.getPhoneNumber())
                .id(entity.getId())
                .build();
    }
}
