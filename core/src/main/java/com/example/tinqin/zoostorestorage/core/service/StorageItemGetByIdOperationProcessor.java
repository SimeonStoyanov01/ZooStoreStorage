package com.example.tinqin.zoostorestorage.core.service;

import com.example.tinqin.zoostore.API.operation.item.getbyid.ItemGetByIdResponse;
import com.example.tinqin.zoostorestorage.API.operation.item.getbyid.StorageItemGetByIdOperation;
import com.example.tinqin.zoostorestorage.API.operation.item.getbyid.StorageItemGetByIdRequest;
import com.example.tinqin.zoostorestorage.API.operation.item.getbyid.StorageItemGetByIdResponse;
import com.example.tinqin.zoostorestorage.core.exceptions.NoStorageItemWithSuchIdException;
import com.example.tinqin.zoostorestorage.persistence.entity.StorageEntity;
import com.example.tinqin.zoostorestorage.persistence.repository.StorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StorageItemGetByIdOperationProcessor implements StorageItemGetByIdOperation {
    private final StorageRepository storageRepository;
    @Override
    public StorageItemGetByIdResponse process(StorageItemGetByIdRequest operationInput) {
        StorageEntity storage=this.storageRepository.findStorageEntityByItemId(UUID.fromString(operationInput.getId())).orElseThrow(NoStorageItemWithSuchIdException::new);
        return StorageItemGetByIdResponse
                .builder()
                .id(storage.getItemId())
                .price(storage.getPrice())
                .quantity(storage.getQuantity())
                .build();
    }
}
