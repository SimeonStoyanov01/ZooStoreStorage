package com.example.tinqin.zoostorestorage.API.controller;

import com.example.tinqin.zoostorestorage.API.request.StorageItemAddRequest;
import com.example.tinqin.zoostorestorage.API.request.StorageItemExportRequest;
import com.example.tinqin.zoostorestorage.API.request.StorageItemImportRequest;
import com.example.tinqin.zoostorestorage.API.response.StorageItemAddResponse;
import com.example.tinqin.zoostorestorage.API.response.StorageItemExportResponse;
import com.example.tinqin.zoostorestorage.API.response.StorageItemImportResponse;
import com.example.tinqin.zoostorestorage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {

    private final StorageService storageService;
    @Autowired
    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }
    @PostMapping("/addItem")
    public ResponseEntity<StorageItemAddResponse> addItem(@RequestBody StorageItemAddRequest storageItemAddRequest){
        return ResponseEntity.ok(storageService.addItem(storageItemAddRequest));
    }

    @PatchMapping("/importItem")
    public ResponseEntity<StorageItemImportResponse> addItem(@RequestBody StorageItemImportRequest storageItemImportRequest){
        return ResponseEntity.ok(storageService.importItem(storageItemImportRequest));
    }

    @PatchMapping("/exportItem")
    public ResponseEntity<?> exportItem(@RequestBody StorageItemExportRequest storageItemExportRequest){
        StorageItemExportResponse storageItemExportResponse;
        try {
            storageItemExportResponse = storageService.exportItem(storageItemExportRequest);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(storageItemExportResponse);
    }

}
