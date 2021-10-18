package com.cachelld.cache.evictionPolicy;

public class DoublyLinkedList<Key> {
    Key key;
    DoublyLinkedList<Key> prev;
    DoublyLinkedList<Key> next;

    public DoublyLinkedList(Key key) {
        this.key = key;
        prev = null;
        next = null;
    }
}
