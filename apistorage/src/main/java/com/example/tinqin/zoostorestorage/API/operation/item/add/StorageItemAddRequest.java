package com.example.tinqin.zoostorestorage.API.operation.item.add;

import com.example.tinqin.zoostorestorage.API.base.OperationInput;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class StorageItemAddRequest implements OperationInput {

    private String itemId;
    private BigDecimal price;
}

