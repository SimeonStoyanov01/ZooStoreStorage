package com.example.tinqin.bff.restexport;

import com.example.tinqin.zoostorestorage.API.operation.item.add.StorageItemAddRequest;
import com.example.tinqin.zoostorestorage.API.operation.item.add.StorageItemAddResponse;
import com.example.tinqin.zoostorestorage.API.operation.item.export.StorageItemExportRequest;
import com.example.tinqin.zoostorestorage.API.operation.item.export.StorageItemExportResponse;
import com.example.tinqin.zoostorestorage.API.operation.item.getAll.GetCollectionOfStorageItemsByItemIdRequest;
import com.example.tinqin.zoostorestorage.API.operation.item.getAll.GetCollectionOfStorageItemsByItemIdResponse;
import com.example.tinqin.zoostorestorage.API.operation.item.getbyid.StorageItemGetByIdResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Set;

@Headers({"Content-Type: application/json"})
public interface ZooStoreStorageRestClient {
    @RequestLine("POST /storageItems/newItem")
    StorageItemAddResponse storageItemAdd(@Param StorageItemAddRequest storageItemAddRequest);
    @RequestLine("GET /storageItems/{id}")
    StorageItemGetByIdResponse getStorageItemById(@Param String id);

    @RequestLine("POST /storageItems/collection")
    GetCollectionOfStorageItemsByItemIdResponse getItemCollection(@RequestBody GetCollectionOfStorageItemsByItemIdRequest storageItem);

    @RequestLine("PUT /storageItems/exportItem")
    StorageItemExportResponse exportItem( StorageItemExportRequest storageItemExportRequest);


}
