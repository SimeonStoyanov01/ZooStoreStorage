package com.example.tinqin.zoostorestorage.API.request;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class StorageItemImportRequest {

    private UUID itemId;
    private Integer quantity;
}
