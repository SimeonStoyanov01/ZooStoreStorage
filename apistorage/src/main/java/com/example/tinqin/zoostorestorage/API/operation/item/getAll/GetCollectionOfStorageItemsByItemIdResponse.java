package com.example.tinqin.zoostorestorage.API.operation.item.getAll;

import com.example.tinqin.zoostorestorage.API.base.OperationResult;
import lombok.*;

import java.util.List;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetCollectionOfStorageItemsByItemIdResponse implements OperationResult {
    private List<StorageItemForCollectionResponse> storageCollection;

}
