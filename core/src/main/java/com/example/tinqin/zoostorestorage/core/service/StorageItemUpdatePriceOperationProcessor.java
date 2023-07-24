package com.example.tinqin.zoostorestorage.core.service;

import com.example.tinqin.zoostorestorage.API.operation.item.update.StorageItemUpdatePriceOperation;
import com.example.tinqin.zoostorestorage.API.operation.item.update.StorageItemUpdatePriceRequest;
import com.example.tinqin.zoostorestorage.API.operation.item.update.StorageItemUpdatePriceResponse;
import com.example.tinqin.zoostorestorage.persistence.entity.StorageEntity;
import com.example.tinqin.zoostorestorage.persistence.repository.StorageRepository;
import org.springframework.stereotype.Service;

@Service
public class StorageItemUpdatePriceOperationProcessor implements StorageItemUpdatePriceOperation {

    private final StorageRepository storageRepository;

    public StorageItemUpdatePriceOperationProcessor(StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    @Override
    public StorageItemUpdatePriceResponse process(StorageItemUpdatePriceRequest operationInput) {
        StorageEntity storageEntity=storageRepository.findById(operationInput.getItemId()).orElseThrow(null);
        storageEntity.setPrice(operationInput.getPrice());
        StorageEntity updateEntity = storageRepository.save(storageEntity);
        StorageItemUpdatePriceResponse updatePriceResponse=StorageItemUpdatePriceResponse
                .builder()
                .storageID(updateEntity.getStorageID())
                .itemId(updateEntity.getItemId())
                .price(updateEntity.getPrice())
                .quantity(updateEntity.getQuantity())
                .build();
        return updatePriceResponse;
    }
}
