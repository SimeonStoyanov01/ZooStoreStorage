package com.example.tinqin.zoostorestorage.API.operation.item.getbyid;

import com.example.tinqin.zoostorestorage.API.base.OperationResult;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StorageItemGetByIdResponse implements OperationResult {
    private UUID id;
    private BigDecimal price;
    private Integer quantity;
}
