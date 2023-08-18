package com.example.tinqin.zoostorestorage.API.operation.item.export;

import com.example.tinqin.zoostorestorage.API.base.OperationInput;
import lombok.*;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StorageItemExportRequest implements OperationInput {

    private UUID itemId;
    private Integer quantity;
}
