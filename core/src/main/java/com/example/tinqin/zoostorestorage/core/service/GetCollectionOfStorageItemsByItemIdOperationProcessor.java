package com.example.tinqin.zoostorestorage.core.service;

import com.example.tinqin.zoostorestorage.API.operation.item.getAll.GetCollectionOfStorageItemsByItemIdOperation;
import com.example.tinqin.zoostorestorage.API.operation.item.getAll.GetCollectionOfStorageItemsByItemIdRequest;
import com.example.tinqin.zoostorestorage.API.operation.item.getAll.GetCollectionOfStorageItemsByItemIdResponse;
import com.example.tinqin.zoostorestorage.API.operation.item.getAll.StorageItemForCollectionResponse;
import com.example.tinqin.zoostorestorage.persistence.entity.StorageEntity;
import com.example.tinqin.zoostorestorage.persistence.repository.StorageRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GetCollectionOfStorageItemsByItemIdOperationProcessor implements GetCollectionOfStorageItemsByItemIdOperation {
    private final StorageRepository storageRepository;

    public GetCollectionOfStorageItemsByItemIdOperationProcessor(StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    @Override
    public GetCollectionOfStorageItemsByItemIdResponse process(GetCollectionOfStorageItemsByItemIdRequest operationInput) {
       // Set<StorageEntity> storage=storageRepository.findByItemIdIn(operationInput.getItemId()).orElseThrow(()->new RuntimeException("No such item"));
        List<StorageItemForCollectionResponse> itemList=new ArrayList<>();
        List<UUID> uuidList=operationInput.getItemId().stream().map(UUID::fromString).toList();
        List<StorageEntity> storage= this.storageRepository.findByItemIdIn(uuidList);
        for (StorageEntity storageEntity : storage) {

            StorageItemForCollectionResponse storageItemForCollectionResponse=
                    StorageItemForCollectionResponse
                            .builder()
                            .id(storageEntity.getItemId().toString())
                            .price(storageEntity.getPrice())
                            .quantity(storageEntity.getQuantity())
                            .build();
            itemList.add(storageItemForCollectionResponse);
        }

        return GetCollectionOfStorageItemsByItemIdResponse
                .builder()
                .storageCollection(itemList)
                .build();
    }
}
