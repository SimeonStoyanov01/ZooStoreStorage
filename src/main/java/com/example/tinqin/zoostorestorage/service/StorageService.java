package com.example.tinqin.zoostorestorage.service;

import com.example.tinqin.zoostorestorage.API.request.StorageItemAddRequest;
import com.example.tinqin.zoostorestorage.API.request.StorageItemExportRequest;
import com.example.tinqin.zoostorestorage.API.request.StorageItemImportRequest;
import com.example.tinqin.zoostorestorage.API.response.StorageItemAddResponse;
import com.example.tinqin.zoostorestorage.API.response.StorageItemExportResponse;
import com.example.tinqin.zoostorestorage.API.response.StorageItemImportResponse;

public interface StorageService {

    StorageItemImportResponse importItem(StorageItemImportRequest storageItemImportRequest);
    StorageItemAddResponse addItem(StorageItemAddRequest storageItemAddRequest);

    StorageItemExportResponse exportItem(StorageItemExportRequest storageItemExportRequest);
}
