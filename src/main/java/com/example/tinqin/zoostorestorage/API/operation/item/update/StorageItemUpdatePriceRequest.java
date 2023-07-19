package com.example.tinqin.zoostorestorage.API.operation.item.update;

import com.example.tinqin.zoostorestorage.API.base.OperationInput;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class StorageItemUpdatePriceRequest implements OperationInput{

    private UUID itemId;
    private BigDecimal price;
}