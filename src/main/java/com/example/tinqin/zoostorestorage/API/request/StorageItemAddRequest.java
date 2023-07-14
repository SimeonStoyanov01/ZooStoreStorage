package com.example.tinqin.zoostorestorage.API.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;
@Getter
@Setter
public class StorageItemAddRequest {

    private UUID itemId;
    private BigDecimal price;
}

