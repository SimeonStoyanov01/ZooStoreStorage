package com.example.tinqin.zoostorestorage.API.operation.item.add;

import com.example.tinqin.zoostorestorage.API.base.OperationInput;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StorageItemAddRequest implements OperationInput {

    private String itemId;
    private BigDecimal price;
}

