package com.example.tinqin.zoostorestorage.API.response;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class StorageItemAddResponse {

    private UUID storageID;
    private UUID itemId;
    private BigDecimal price;
    private Integer quantity;
}
