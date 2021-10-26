package com.example.dodopoint.store.dto;

import com.example.dodopoint.common.validation.ValidationGroup;
import com.example.dodopoint.store.domain.entity.StoreEntity;
import com.example.dodopoint.store.domain.value.Address;
import com.example.dodopoint.store.exception.StoreErrorResult;
import com.example.dodopoint.store.exception.StoreException;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
public class RequestStoreDTO {

    @NotBlank(groups = {ValidationGroup.insert.class, ValidationGroup.update.class}, message = "가게이름이 지정되지 않았습니다")
    private String storeName;

    @NotBlank(groups = {ValidationGroup.insert.class, ValidationGroup.update.class}, message = "가게 전화번호가 지정되지 않았습니다")
    private String phoneNumber;

    @NotBlank(groups = {ValidationGroup.insert.class, ValidationGroup.update.class}, message = "가게 주소가 지정되지 않았습니다")
    private String address;

    @NotBlank(groups = {ValidationGroup.insert.class, ValidationGroup.update.class}, message = "가게 우편번호가 지정되지 않았습니다")
    private String zipCode;


    public StoreEntity toEntity(){
        return StoreEntity.builder()
                .storeName(storeName)
                .address(
                        Address.builder()
                                .address(address)
                                .zipCode(zipCode)
                                .build()
                )
                .phoneNumber(phoneNumber)
                .build();
    }
    public StoreEntity toEntity(Long id){
        return StoreEntity.builder()
                .storeName(storeName)
                .address(
                        Address.builder()
                                .address(address)
                                .zipCode(zipCode)
                                .build()
                )
                .phoneNumber(phoneNumber)
                .id(id)
                .build();
    }
}
