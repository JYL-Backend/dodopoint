package com.example.dodopoint.store.service;

import com.example.dodopoint.common.response.BasicResponse;
import com.example.dodopoint.common.validation.ValidationGroup;
import com.example.dodopoint.store.domain.entity.StoreEntity;
import com.example.dodopoint.store.dto.RequestStoreDTO;
import com.example.dodopoint.store.dto.ResponseStoreDTO;
import com.example.dodopoint.store.exception.StoreErrorResult;
import com.example.dodopoint.store.exception.StoreException;
import com.example.dodopoint.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreService {
    final private StoreRepository storeRepository;

    /* 가게 생성 */
    public BasicResponse createStore(RequestStoreDTO dto){
        //가게명이 이미 존재하면 예외
        Optional<StoreEntity> byStoreName = storeRepository.findByStoreName(dto.getStoreName());
        if(!byStoreName.isEmpty()){
            throw new StoreException(StoreErrorResult.ISSET_STORE_NAME);
        }

        BasicResponse basicResponse = new BasicResponse();

        StoreEntity storeEntity = dto.toEntity();
        storeRepository.save(storeEntity);

        basicResponse.setData(storeEntity);

        return basicResponse;
    }

    /* 가게 수정 */
    public BasicResponse editStore(Long id, RequestStoreDTO dto){
        BasicResponse basicResponse = new BasicResponse();

        Optional<StoreEntity> findStore = storeRepository.findById(id);
        //가게를 찾을 수 없을 때
        if(findStore.isEmpty()){
            throw new StoreException(StoreErrorResult.NOT_FOUND_STORE);
        }
        //이미 존재하는 가게명일때
        Optional<StoreEntity> byStoreName = storeRepository.findByStoreName(dto.getStoreName());
        if(isSetStoreName(id, byStoreName)){
            throw new StoreException(StoreErrorResult.ISSET_STORE_NAME);
        }

        // 수정
        StoreEntity storeEntity = dto.toEntity(id);

        basicResponse.setData(storeRepository.save(storeEntity));

        return basicResponse;
    }

    // 해당 id를 제외한 가게중 중복되는 가게명이 존재하는가
    private boolean isSetStoreName(Long id, Optional<StoreEntity> byStoreName) {
        return !byStoreName.isEmpty() && byStoreName.get().getId() != id;
    }

    /* 가게 삭제 */
    public BasicResponse deleteStore(Long id) {
        BasicResponse basicResponse = new BasicResponse();
        Optional<StoreEntity> findStore = storeRepository.findById(id);
        // 존재하지 않음
        if(findStore.isEmpty()){
            throw new StoreException(StoreErrorResult.NOT_FOUND_STORE);
        }

        // 삭제
        storeRepository.deleteById(id);

        return basicResponse;
    }

    public BasicResponse getStore(Long id) {
        BasicResponse basicResponse = new BasicResponse();

        Optional<StoreEntity> findStore = storeRepository.findById(id);
        if(findStore.isEmpty()){
            throw new StoreException(StoreErrorResult.NOT_FOUND_STORE);
        }

        basicResponse.setData(ResponseStoreDTO.getResponseStoreDTO(findStore.get()));

        return basicResponse;
    }

    /* 가게 조회 */
}
