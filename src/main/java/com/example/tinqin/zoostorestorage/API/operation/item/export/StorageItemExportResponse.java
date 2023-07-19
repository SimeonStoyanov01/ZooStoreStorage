package com.example.tinqin.zoostorestorage.API.operation.item.export;

import com.example.tinqin.zoostorestorage.API.base.OperationResult;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class StorageItemExportResponse implements OperationResult {
    private UUID storageID;
    private UUID itemId;
    private BigDecimal price;
    private Integer quantity;
}
