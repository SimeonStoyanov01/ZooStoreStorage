package com.example.tinqin.zoostorestorage.core.service;

import com.example.tinqin.zoostorestorage.API.operation.item.add.StorageItemAddOperation;
import com.example.tinqin.zoostorestorage.API.operation.item.add.StorageItemAddRequest;
import com.example.tinqin.zoostorestorage.API.operation.item.add.StorageItemAddResponse;
import com.example.tinqin.zoostorestorage.persistence.entity.StorageEntity;
import com.example.tinqin.zoostorestorage.persistence.repository.StorageRepository;
import org.springframework.stereotype.Service;

@Service
public class StorageItemAddOperationProcessor implements StorageItemAddOperation {

    private final StorageRepository storageRepository;

    public StorageItemAddOperationProcessor(StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }


//    @Override
//    public StorageItemAddResponse addItem(StorageItemAddRequest storageItemAddRequest) {
//        StorageEntity storageEntity=new StorageEntity();
//        storageEntity.setItemId(storageItemAddRequest.getItemId());
//        storageEntity.setQuantity(0);
//        storageEntity.setPrice(storageItemAddRequest.getPrice());
//        storageRepository.save(storageEntity);
//        StorageItemAddResponse addResponse = StorageItemAddResponse
//                .builder()
//                .storageID(storageEntity.getStorageID())
//                .itemId(storageEntity.getItemId())
//                .price(storageEntity.getPrice())
//                .quantity(storageEntity.getQuantity())
//                .build();
//        return addResponse;
//    }
//
//    @Override
//    public StorageItemExportResponse exportItem(StorageItemExportRequest storageItemExportRequest) {
//        StorageEntity storageEntity=storageRepository.findById(storageItemExportRequest.getItemId()).orElseThrow(null);
//        if(storageEntity.getQuantity()<storageItemExportRequest.getQuantity()){
//            throw new RuntimeException();
//        }
//        storageEntity.setQuantity(storageEntity.getQuantity()-storageItemExportRequest.getQuantity());
//        StorageEntity updateEntity = storageRepository.save(storageEntity);
//        StorageItemExportResponse itemExportResponse=StorageItemExportResponse
//                .builder()
//                .storageID(updateEntity.getStorageID())
//                .itemId(updateEntity.getItemId())
//                .price(updateEntity.getPrice())
//                .quantity(updateEntity.getQuantity())
//                .build();
//        return itemExportResponse;
//    }
//
//    @Override
//    public StorageItemUpdatePriceResponse updatePrice(StorageItemUpdatePriceRequest storageItemUpdatePriceRequest) {
//        StorageEntity storageEntity=storageRepository.findById(storageItemUpdatePriceRequest.getItemId()).orElseThrow(null);
//        storageEntity.setPrice(storageItemUpdatePriceRequest.getPrice());
//        StorageEntity updateEntity = storageRepository.save(storageEntity);
//        StorageItemUpdatePriceResponse updatePriceResponse=StorageItemUpdatePriceResponse
//                .builder()
//                .storageID(updateEntity.getStorageID())
//                .itemId(updateEntity.getItemId())
//                .price(updateEntity.getPrice())
//                .quantity(updateEntity.getQuantity())
//                .build();
//        return updatePriceResponse;
//    }


    @Override
    public StorageItemAddResponse process(StorageItemAddRequest operationInput) {
        StorageEntity storageEntity=new StorageEntity();
        storageEntity.setItemId(operationInput.getItemId());
        storageEntity.setQuantity(0);
        storageEntity.setPrice(operationInput.getPrice());
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
}
