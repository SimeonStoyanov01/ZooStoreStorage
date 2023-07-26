package com.example.tinqin.zoostorestorage.persistence.repository;


import com.example.tinqin.zoostorestorage.persistence.entity.StorageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface StorageRepository extends JpaRepository<StorageEntity, UUID> {

    Optional<StorageEntity> findStorageEntityByItemId(UUID uuid);

    boolean existsByItemId(UUID uuid);
}
