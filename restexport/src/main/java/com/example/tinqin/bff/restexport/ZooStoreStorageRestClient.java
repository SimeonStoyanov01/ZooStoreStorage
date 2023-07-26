package com.example.tinqin.bff.restexport;

import com.example.tinqin.zoostorestorage.API.operation.item.add.StorageItemAddRequest;
import com.example.tinqin.zoostorestorage.API.operation.item.add.StorageItemAddResponse;
import com.example.tinqin.zoostorestorage.API.operation.item.getbyid.StorageItemGetByIdRequest;
import com.example.tinqin.zoostorestorage.API.operation.item.getbyid.StorageItemGetByIdResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Headers({"Content-Type: application/json"})
public interface ZooStoreStorageRestClient {
    @RequestLine("POST /storageItems/newItem")
    StorageItemAddResponse storageItemAdd(@Param StorageItemAddRequest storageItemAddRequest);
    @RequestLine("GET /storageItems/{id}")
    StorageItemGetByIdResponse getStorageItemById(@Param String id);


}
