package com.example.tinqin.zoostorestorage.API.operation.item.getAll;

import com.example.tinqin.zoostorestorage.API.base.OperationResult;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StorageItemForCollectionResponse implements OperationResult {
    private String id;
    private BigDecimal price;
    private Integer quantity;
}
