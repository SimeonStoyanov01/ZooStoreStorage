package com.example.tinqin.zoostorestorage.core.service;

import com.example.tinqin.zoostorestorage.API.operation.item.export.StorageItemExportOperation;
import com.example.tinqin.zoostorestorage.API.operation.item.export.StorageItemExportRequest;
import com.example.tinqin.zoostorestorage.API.operation.item.export.StorageItemExportResponse;
import com.example.tinqin.zoostorestorage.persistence.entity.StorageEntity;
import com.example.tinqin.zoostorestorage.persistence.repository.StorageRepository;
import org.springframework.stereotype.Service;

@Service
public class StorageItemExportOperationProcessor implements StorageItemExportOperation {
    private final StorageRepository storageRepository;

    public StorageItemExportOperationProcessor(StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    @Override
    public StorageItemExportResponse process(StorageItemExportRequest operationInput) {
        StorageEntity storageEntity=storageRepository.findStorageEntityByItemId(operationInput.getItemId())
                .orElseThrow(null);
        if(storageEntity.getQuantity()<operationInput.getQuantity()){
            throw new RuntimeException();
        }
        storageEntity.setQuantity(storageEntity.getQuantity()-operationInput.getQuantity());
        StorageEntity updateEntity = storageRepository.save(storageEntity);
        return StorageItemExportResponse
                .builder()
                .storageID(updateEntity.getStorageID())
                .itemId(updateEntity.getItemId())
                .price(updateEntity.getPrice())
                .quantity(updateEntity.getQuantity())
                .build();
    }
}
