package com.example.tinqin.zoostorestorage.API.operation.item.getbyid;

import com.example.tinqin.zoostorestorage.API.base.OperationInput;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StorageItemGetByIdRequest implements OperationInput {
    private String id;
}
