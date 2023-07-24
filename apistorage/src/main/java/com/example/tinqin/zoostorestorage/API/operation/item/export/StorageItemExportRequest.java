package com.example.tinqin.zoostorestorage.API.operation.item.export;

import com.example.tinqin.zoostorestorage.API.base.OperationInput;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class StorageItemExportRequest implements OperationInput {

    private UUID itemId;
    private Integer quantity;
}
