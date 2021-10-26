package com.example.dodopoint.store.domain.value;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Address {
    @Column(name = "address")
    private String address;
    @Column(name = "zip_code")
    private String zipCode;
}
