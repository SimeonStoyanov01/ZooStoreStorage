package com.example.tinqin.zoostorestorage.API.base;

public interface OperationProcessor<R extends OperationResult,T extends OperationInput> {
    R process(T operationInput);

}
