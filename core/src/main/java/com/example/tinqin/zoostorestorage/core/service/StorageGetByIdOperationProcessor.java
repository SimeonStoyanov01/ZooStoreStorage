package com.example.tinqin.zoostorestorage.core.service;

import com.example.tinqin.zoostorestorage.API.operation.item.getbyid.StorageItemGetByIdOperation;
import com.example.tinqin.zoostorestorage.API.operation.item.getbyid.StorageItemGetByIdRequest;
import com.example.tinqin.zoostorestorage.API.operation.item.getbyid.StorageItemGetByIdResponse;
import com.example.tinqin.zoostorestorage.persistence.entity.StorageEntity;
import com.example.tinqin.zoostorestorage.persistence.repository.StorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StorageGetByIdOperationProcessor implements StorageItemGetByIdOperation {
    private final StorageRepository storageRepository;
    @Override
    public StorageItemGetByIdResponse process(StorageItemGetByIdRequest operationInput) {
        StorageEntity buf= StorageEntity.builder().itemId(UUID.fromString("00000000-0000-0000-0000-000000000000")).build();
        StorageEntity storage=this.storageRepository.findStorageEntityByItemId(UUID.fromString(operationInput.getId())).orElse(buf);

        return StorageItemGetByIdResponse
                .builder()
                .id(String.valueOf(storage.getItemId()))
                .price(storage.getPrice())
                .quantity(storage.getQuantity())
                .build();
    }
}
