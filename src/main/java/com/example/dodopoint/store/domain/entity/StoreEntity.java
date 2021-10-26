package com.example.dodopoint.store.domain.entity;

import com.example.dodopoint.common.entity.BaseEntity;
import com.example.dodopoint.store.domain.value.Address;
import com.example.dodopoint.store.exception.StoreErrorResult;
import com.example.dodopoint.store.exception.StoreException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreEntity extends BaseEntity {
    @Id @GeneratedValue
    private Long id;

    @Column(name = "store_name", nullable = false, unique = true)
    @NotNull(message = "가게명을 입력하세요")
    private String storeName;

    @Embedded
    private Address address;

    @Column(name = "phone_number")
    private String phoneNumber;

    // 가게 이름 수정
    public void changeStoreName(String changeStoreName) {
        // 가게 이름 비었을 경우 예외
        if(changeStoreName==null || changeStoreName.equals("")){
            throw new StoreException(StoreErrorResult.EMPTY_STORE_NAME);
        }
        this.storeName = changeStoreName;
    }
}
