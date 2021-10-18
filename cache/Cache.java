package com.cachelld.cache;

import com.cachelld.cache.evictionPolicy.EvictionPolicy;
import com.cachelld.cache.exception.KeyNotFoundException;
import com.cachelld.cache.exception.StorageFullException;
import com.cachelld.cache.storage.Storage;

public class Cache <Key,Value>{

    private final EvictionPolicy<Key> evictionPolicy;
    private final Storage<Key,Value> storage;
    public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key,Value> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void getKey(Key key){

        try {
            Value v = storage.get(key);
            evictionPolicy.keyAccessed(key);
            System.out.println("Key Found "+ key + " ==== > " + v);
        } catch (KeyNotFoundException e) {
            System.out.println("KeyNot Found");
        }

    }
    public void putKey(Key key,Value value){

        try {
            storage.put(key,value);
            evictionPolicy.keyAccessed(key);
            System.out.println("Successfully Added");
        } catch (StorageFullException e) {
            System.out.println("Storage Full Evicting Key");
            Key evictedKey = evictionPolicy.evictKey();
            System.out.println("Evicting Key " + evictedKey);
            try {
                storage.remove(evictedKey);
                putKey(key,value);
            } catch (KeyNotFoundException ex) {
                System.out.println("Unexpected Result");
                System.exit(0);
            }
        }




    }

}
