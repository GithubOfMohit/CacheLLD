package com.cachelld.cache.storage;

import com.cachelld.cache.exception.KeyNotFoundException;
import com.cachelld.cache.exception.StorageFullException;

import java.util.HashMap;

public class HashMapStorage<Key,Value> implements Storage<Key,Value>{


    private HashMap<Key,Value> storage;
    Integer capacity;
    public HashMapStorage(Integer capacity) {
        this.storage = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    @Override
    public void put(Key key, Value value) throws StorageFullException {
        if(storageIsFull()){
            throw new StorageFullException("Storage Is Full");
        }
        storage.put(key,value);
    }

    @Override
    public Value get(Key key) throws KeyNotFoundException{
        if(!storage.containsKey(key)){
            throw new KeyNotFoundException("Key Not Found");
        }
        return storage.get(key);
    }

    @Override
    public void remove(Key key) throws KeyNotFoundException{
        if(!storage.containsKey(key)){
            throw new KeyNotFoundException("Keys Not Found");
        }
        storage.remove(key);
        return;
    }

    public Boolean storageIsFull(){
        return storage.size() == capacity;
    }
}
