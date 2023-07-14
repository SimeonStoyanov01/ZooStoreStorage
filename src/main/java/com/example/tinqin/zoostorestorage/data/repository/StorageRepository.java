package com.example.tinqin.zoostorestorage.data.repository;


import com.example.tinqin.zoostorestorage.data.entity.StorageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface StorageRepository extends JpaRepository<StorageEntity, UUID> {
}
