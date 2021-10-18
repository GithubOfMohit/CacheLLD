package com.cachelld.cache.storage;

import com.cachelld.cache.exception.KeyNotFoundException;
import com.cachelld.cache.exception.StorageFullException;

public interface Storage <Key,Value>{

    public void put(Key key,Value value) throws StorageFullException;
    public Value get(Key key) throws KeyNotFoundException;
    public void remove(Key key) throws KeyNotFoundException;
}
