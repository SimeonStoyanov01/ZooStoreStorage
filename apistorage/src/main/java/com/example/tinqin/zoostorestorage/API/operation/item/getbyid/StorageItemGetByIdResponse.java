package com.example.tinqin.zoostorestorage.API.operation.item.getbyid;

import com.example.tinqin.zoostorestorage.API.base.OperationResult;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StorageItemGetByIdResponse implements OperationResult {
    private String id;
    private BigDecimal price;
    private Integer quantity;
}
