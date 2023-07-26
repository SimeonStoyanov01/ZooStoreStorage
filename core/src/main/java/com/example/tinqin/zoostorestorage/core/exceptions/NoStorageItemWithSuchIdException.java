package com.example.tinqin.zoostorestorage.core.exceptions;

public class NoStorageItemWithSuchIdException extends RuntimeException{
    public NoStorageItemWithSuchIdException() {
        super("There is no storage item with such ID");
    }
}
