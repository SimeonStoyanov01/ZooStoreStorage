package com.example.tinqin.zoostorestorage.API.operation.item.getAll;

import com.example.tinqin.zoostorestorage.API.base.OperationInput;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetCollectionOfStorageItemsByItemIdRequest implements OperationInput {
    private List<String> itemId;
}
