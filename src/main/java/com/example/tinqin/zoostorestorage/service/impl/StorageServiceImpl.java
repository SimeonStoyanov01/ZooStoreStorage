package com.example.tinqin.zoostorestorage.service.impl;

import com.example.tinqin.zoostorestorage.API.request.StorageItemAddRequest;
import com.example.tinqin.zoostorestorage.API.request.StorageItemExportRequest;
import com.example.tinqin.zoostorestorage.API.request.StorageItemImportRequest;
import com.example.tinqin.zoostorestorage.API.response.StorageItemAddResponse;
import com.example.tinqin.zoostorestorage.API.response.StorageItemExportResponse;
import com.example.tinqin.zoostorestorage.API.response.StorageItemImportResponse;
import com.example.tinqin.zoostorestorage.data.entity.StorageEntity;
import com.example.tinqin.zoostorestorage.data.repository.StorageRepository;
import com.example.tinqin.zoostorestorage.service.StorageService;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImpl implements StorageService {

    private final StorageRepository storageRepository;

    public StorageServiceImpl(StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    @Override
    public StorageItemImportResponse importItem(StorageItemImportRequest storageItemImportRequest) {
        StorageEntity storageEntity=storageRepository.findById(storageItemImportRequest.getItemId()).orElseThrow(null);
        storageEntity.setQuantity(storageEntity.getQuantity()+storageItemImportRequest.getQuantity());
        StorageEntity updateEntity = storageRepository.save(storageEntity);
        StorageItemImportResponse itemImportResponse=StorageItemImportResponse
                .builder()
                .storageID(updateEntity.getStorageID())
                .itemId(updateEntity.getItemId())
                .price(updateEntity.getPrice())
                .quantity(updateEntity.getQuantity())
                .build();
        return itemImportResponse;
    }

    @Override
    public StorageItemAddResponse addItem(StorageItemAddRequest storageItemAddRequest) {
        StorageEntity storageEntity=new StorageEntity();
        storageEntity.setItemId(storageItemAddRequest.getItemId());
        storageEntity.setQuantity(0);
        storageEntity.setPrice(storageItemAddRequest.getPrice());
        storageRepository.save(storageEntity);
        StorageItemAddResponse addResponse = StorageItemAddResponse
                .builder()
                .storageID(storageEntity.getStorageID())
                .itemId(storageEntity.getItemId())
                .price(storageEntity.getPrice())
                .quantity(storageEntity.getQuantity())
                .build();
        return addResponse;
    }

    @Override
    public StorageItemExportResponse exportItem(StorageItemExportRequest storageItemExportRequest) {
        StorageEntity storageEntity=storageRepository.findById(storageItemExportRequest.getItemId()).orElseThrow(null);
        if(storageEntity.getQuantity()<storageItemExportRequest.getQuantity()){
            throw new RuntimeException();
        }
        storageEntity.setQuantity(storageEntity.getQuantity()-storageItemExportRequest.getQuantity());
        StorageEntity updateEntity = storageRepository.save(storageEntity);
        StorageItemExportResponse itemExportResponse=StorageItemExportResponse
                .builder()
                .storageID(updateEntity.getStorageID())
                .itemId(updateEntity.getItemId())
                .price(updateEntity.getPrice())
                .quantity(updateEntity.getQuantity())
                .build();
        return itemExportResponse;
    }
}
