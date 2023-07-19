package com.example.tinqin.zoostorestorage.API.operation.item.importstorage;

import com.example.tinqin.zoostorestorage.API.base.OperationInput;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class StorageItemImportRequest implements OperationInput {

    private UUID itemId;
    private Integer quantity;
}
