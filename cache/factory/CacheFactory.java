package com.cachelld.cache.factory;

import com.cachelld.cache.Cache;
import com.cachelld.cache.evictionPolicy.LRU;
import com.cachelld.cache.storage.HashMapStorage;

public class CacheFactory<Key,Value> {

    private static CacheFactory cacheFactoryInstance;
    private static Cache cache;
    private CacheFactory() {
        cache = new Cache<Integer,Integer>(new LRU(5), new HashMapStorage(5));
    }

    public static CacheFactory getInstance() {
        if (cacheFactoryInstance == null) {
            cacheFactoryInstance = new CacheFactory();
        }
        return cacheFactoryInstance;
    }

    public Cache<Integer,Integer> getDefaultCache(){
        return cache;
    }
}
