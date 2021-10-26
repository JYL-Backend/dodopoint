package com.example.dodopoint.store.repository;

import com.example.dodopoint.store.domain.entity.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<StoreEntity,Long> {
    Optional<StoreEntity> findByStoreName(String storeName);
}
