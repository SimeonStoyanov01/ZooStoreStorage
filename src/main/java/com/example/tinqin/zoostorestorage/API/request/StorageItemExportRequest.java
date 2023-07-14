package com.example.tinqin.zoostorestorage.API.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class StorageItemExportRequest {

    private UUID itemId;
    private Integer quantity;
}
