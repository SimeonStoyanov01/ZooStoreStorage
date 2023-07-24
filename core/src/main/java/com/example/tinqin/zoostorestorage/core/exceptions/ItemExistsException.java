package com.example.tinqin.zoostorestorage.core.exceptions;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

public class ItemExistsException extends RuntimeException{
    public ItemExistsException(){
        super("Item id already exists in the database");
    }
}
