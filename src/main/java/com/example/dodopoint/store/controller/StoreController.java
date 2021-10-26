package com.example.dodopoint.store.controller;

import com.example.dodopoint.common.validation.ValidationGroup;
import com.example.dodopoint.store.dto.RequestStoreDTO;
import com.example.dodopoint.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class StoreController {

    final public StoreService storeService;

    // 가게 생성
    @PostMapping("/api/v1/store")
    public ResponseEntity createStore(@RequestBody @Validated(ValidationGroup.insert.class) RequestStoreDTO dto){
        return ResponseEntity.ok().body(storeService.createStore(dto));
    }

    // 가게 수정
    @PutMapping("/api/v1/store/{id}")
    public ResponseEntity editStore(
            @PathVariable("id") Long id,
            @RequestBody @Validated(ValidationGroup.update.class) RequestStoreDTO dto){
        return ResponseEntity.ok().body(storeService.editStore(id,dto));
    }

    // 가게 삭제
    @DeleteMapping("/api/v1/store/{id}")
    public ResponseEntity deleteStore(
            @PathVariable("id") Long id){
        return ResponseEntity.ok().body(storeService.deleteStore(id));
    }

    //가게 조회
    @GetMapping("/api/v1/store/{id}")
    public ResponseEntity getStore(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(storeService.getStore(id));
    }
}
