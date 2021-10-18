package com.cachelld.cache.evictionPolicy;

import com.cachelld.cache.exception.KeyNotFoundException;

public interface EvictionPolicy<Key> {

    public void keyAccessed(Key key);
    public Key evictKey();
}
