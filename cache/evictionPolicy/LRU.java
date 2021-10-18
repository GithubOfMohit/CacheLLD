package com.cachelld.cache.evictionPolicy;

import java.util.HashMap;
import java.util.Map;

public class LRU<Key> implements EvictionPolicy<Key>{

    private Map<Key,DoublyLinkedList> keyMap;
    private DoublyLinkedListNode<Key> doublyLinkedList;
    private Integer capacity;
    public LRU(Integer capacity) {
        keyMap = new HashMap<>();
        doublyLinkedList = new DoublyLinkedListNode();
        this.capacity = capacity;
    }

    @Override
    public void keyAccessed(Key key) {
        if(!keyMap.containsKey(key)){
            DoublyLinkedList<Key> newNode = doublyLinkedList.addNewNode(key);
            keyMap.put(key,newNode);
        }
        else{
            doublyLinkedList.updateKeyPosition(keyMap.get(key));
        }
    }

    @Override
    public Key evictKey() {
        doublyLinkedList.evictFirstPosition();
        return doublyLinkedList.getFirst().key;
    }
}
