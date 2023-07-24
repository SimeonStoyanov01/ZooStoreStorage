package com.example.tinqin.zoostorestorage.core.service;

import com.example.tinqin.zoostore.restexport.ZooStoreRestClient;

import com.example.tinqin.zoostorestorage.API.operation.item.add.StorageItemAddOperation;
import com.example.tinqin.zoostorestorage.API.operation.item.add.StorageItemAddRequest;
import com.example.tinqin.zoostorestorage.API.operation.item.add.StorageItemAddResponse;
import com.example.tinqin.zoostorestorage.core.exceptions.ItemExistsException;
import com.example.tinqin.zoostorestorage.persistence.entity.StorageEntity;
import com.example.tinqin.zoostorestorage.persistence.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StorageItemAddOperationProcessor implements StorageItemAddOperation {
    private final ZooStoreRestClient zooStoreRestClient;
    private final StorageRepository storageRepository;
    @Autowired
    public StorageItemAddOperationProcessor(ZooStoreRestClient zooStoreRestClient, StorageRepository storageRepository) {
        this.zooStoreRestClient = zooStoreRestClient;
//        this.zooStoreRestClient = zooStoreRestClient;
        this.storageRepository = storageRepository;
    }

    @Override
    public StorageItemAddResponse process(StorageItemAddRequest operationInput) {

        try{
            zooStoreRestClient.itemGetById(operationInput.getItemId());
        }catch (Exception e){throw new RuntimeException("ZooStoreRestClientFactory: item does not exist");}
        if(storageRepository.existsByItemId(UUID.fromString(operationInput.getItemId()))){
            throw new ItemExistsException();
        }
        StorageEntity storageEntity=new StorageEntity();
        storageEntity.setItemId(UUID.fromString(operationInput.getItemId()));
        storageEntity.setQuantity(0);
        storageEntity.setPrice(operationInput.getPrice());
        storageRepository.save(storageEntity);
        return StorageItemAddResponse
                .builder()
                .storageID(storageEntity.getStorageID())
                .itemId(storageEntity.getItemId())
                .price(storageEntity.getPrice())
                .quantity(storageEntity.getQuantity())
                .build();
    }
}
