package com.example.tinqin.zoostorestorage.core.service;

import com.example.tinqin.zoostorestorage.API.operation.item.importstorage.StorageItemImportOperation;
import com.example.tinqin.zoostorestorage.API.operation.item.importstorage.StorageItemImportRequest;
import com.example.tinqin.zoostorestorage.API.operation.item.importstorage.StorageItemImportResponse;
import com.example.tinqin.zoostorestorage.core.exceptions.NoStorageItemWithSuchIdException;
import com.example.tinqin.zoostorestorage.persistence.entity.StorageEntity;
import com.example.tinqin.zoostorestorage.persistence.repository.StorageRepository;
import org.springframework.stereotype.Service;

@Service
public class StorageItemImportOperationProcessor implements StorageItemImportOperation {
    private final StorageRepository storageRepository;

    public StorageItemImportOperationProcessor(StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    @Override
    public StorageItemImportResponse process(StorageItemImportRequest operationInput) {
        StorageEntity storageEntity=storageRepository.findById(operationInput.getItemId()).orElseThrow(NoStorageItemWithSuchIdException::new);
        storageEntity.setQuantity(storageEntity.getQuantity()+operationInput.getQuantity());
        StorageEntity updateEntity = storageRepository.save(storageEntity);
        return StorageItemImportResponse
                .builder()
                .storageID(updateEntity.getStorageID())
                .itemId(updateEntity.getItemId())
                .price(updateEntity.getPrice())
                .quantity(updateEntity.getQuantity())
                .build();
    }

}
