package com.example.tinqin.zoostorestorage.rest.controller;

import com.example.tinqin.zoostorestorage.API.operation.item.add.StorageItemAddOperation;
import com.example.tinqin.zoostorestorage.API.operation.item.add.StorageItemAddRequest;
import com.example.tinqin.zoostorestorage.API.operation.item.export.StorageItemExportOperation;
import com.example.tinqin.zoostorestorage.API.operation.item.export.StorageItemExportRequest;
import com.example.tinqin.zoostorestorage.API.operation.item.getAll.GetCollectionOfStorageItemsByItemIdOperation;
import com.example.tinqin.zoostorestorage.API.operation.item.getAll.GetCollectionOfStorageItemsByItemIdRequest;
import com.example.tinqin.zoostorestorage.API.operation.item.getAll.GetCollectionOfStorageItemsByItemIdResponse;
import com.example.tinqin.zoostorestorage.API.operation.item.getbyid.StorageItemGetByIdOperation;
import com.example.tinqin.zoostorestorage.API.operation.item.getbyid.StorageItemGetByIdRequest;
import com.example.tinqin.zoostorestorage.API.operation.item.getbyid.StorageItemGetByIdResponse;
import com.example.tinqin.zoostorestorage.API.operation.item.importstorage.StorageItemImportOperation;
import com.example.tinqin.zoostorestorage.API.operation.item.importstorage.StorageItemImportRequest;
import com.example.tinqin.zoostorestorage.API.operation.item.update.StorageItemUpdatePriceOperation;
import com.example.tinqin.zoostorestorage.API.operation.item.update.StorageItemUpdatePriceRequest;
import com.example.tinqin.zoostorestorage.API.operation.item.add.StorageItemAddResponse;
import com.example.tinqin.zoostorestorage.API.operation.item.export.StorageItemExportResponse;
import com.example.tinqin.zoostorestorage.API.operation.item.importstorage.StorageItemImportResponse;
import com.example.tinqin.zoostorestorage.API.operation.item.update.StorageItemUpdatePriceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/storageItems")
public class StorageController {

    private final StorageItemAddOperation addItemService;
    private final StorageItemImportOperation importItemService;
    private final StorageItemExportOperation exportItemService;
    private final StorageItemUpdatePriceOperation updatePriceService;

    private final StorageItemGetByIdOperation storageItemGetByIdOperation;

    private final GetCollectionOfStorageItemsByItemIdOperation getCollectionOfStorageItemsByItemIdOperation;
    @Autowired
    public StorageController(StorageItemAddOperation addItemService, StorageItemImportOperation importItemService, StorageItemExportOperation exportItemService, StorageItemUpdatePriceOperation updatePriceService, StorageItemGetByIdOperation storageItemGetByIdOperation, GetCollectionOfStorageItemsByItemIdOperation getCollectionOfStorageItemsByItemIdOperation) {
        this.addItemService = addItemService;
        this.importItemService = importItemService;
        this.exportItemService = exportItemService;
        this.updatePriceService = updatePriceService;
        this.storageItemGetByIdOperation = storageItemGetByIdOperation;
        this.getCollectionOfStorageItemsByItemIdOperation = getCollectionOfStorageItemsByItemIdOperation;
    }


    @PostMapping("/newItem")
    public ResponseEntity<StorageItemAddResponse> addItem(@RequestBody StorageItemAddRequest storageItemAddRequest){
        return ResponseEntity.ok(addItemService.process(storageItemAddRequest));
    }

    @PatchMapping("/importItem")
    public ResponseEntity<StorageItemImportResponse> importItem(@RequestBody StorageItemImportRequest storageItemImportRequest){
        return ResponseEntity.ok(importItemService.process(storageItemImportRequest));
    }

    @PatchMapping("/exportItem")
    public ResponseEntity<?> exportItem(@RequestBody StorageItemExportRequest storageItemExportRequest){
        StorageItemExportResponse storageItemExportResponse;
        try {
            storageItemExportResponse = exportItemService.process(storageItemExportRequest);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(storageItemExportResponse);
    }

    @PatchMapping("/updatePrice")
    public ResponseEntity<StorageItemUpdatePriceResponse> updatePrice(@RequestBody StorageItemUpdatePriceRequest storageItemUpdatePriceRequest){
        return ResponseEntity.ok(updatePriceService.process(storageItemUpdatePriceRequest));
    }
    @GetMapping("/{id}")
    public ResponseEntity<StorageItemGetByIdResponse> getStorageItemById(@PathVariable String id){
        StorageItemGetByIdRequest request=StorageItemGetByIdRequest.builder().id(id).build();
        return ResponseEntity.ok(storageItemGetByIdOperation.process(request));
    }

    @PostMapping("/collection")
    public ResponseEntity<GetCollectionOfStorageItemsByItemIdResponse> getItemCollection(@RequestBody GetCollectionOfStorageItemsByItemIdRequest getCollectionOfStorageItemsByItemIdRequest){
       // StorageItemGetByIdRequest request=StorageItemGetByIdRequest.builder().id(id).build();
        return ResponseEntity.ok(getCollectionOfStorageItemsByItemIdOperation.process(getCollectionOfStorageItemsByItemIdRequest));
    }



}
