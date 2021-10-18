package com.cachelld.cache.evictionPolicy;

public class DoublyLinkedListNode<Key> {

    public DoublyLinkedList<Key> first;
    public DoublyLinkedList<Key> last;

    public DoublyLinkedListNode() {
        first = null;
        last = null;
    }

    public DoublyLinkedList<Key> getFirst() {
        return first;
    }

    public DoublyLinkedList<Key> getLast() {
        return last;
    }

    public DoublyLinkedList<Key> addNewNode(Key key) {
        DoublyLinkedList<Key> node;
        if(first == null && last == null){
            node = new DoublyLinkedList<Key>(key);
            first = node;
            last = node;
        }
        else{
            node = new DoublyLinkedList<Key>(key);
            last.next = node;
            node.prev = last;
            last = node;
        }
        return node;
    }


    public void updateKeyPosition(DoublyLinkedList<Key> doublyLinkedList) {
        // first node
        if(doublyLinkedList.prev == null){
            first = doublyLinkedList.next;
            first.prev = null;
            doublyLinkedList.prev = last;
            doublyLinkedList.next = null;
            last = doublyLinkedList;
        }
        else if(doublyLinkedList.next == null){
            // do nothing
        }
        else{
            doublyLinkedList.next.prev = doublyLinkedList.prev;
            doublyLinkedList.prev.next = doublyLinkedList.next;
            doublyLinkedList.prev = last;
            doublyLinkedList.next = null;
            last.next = doublyLinkedList;
            last = doublyLinkedList;
        }

    }

    public void evictFirstPosition(){
        DoublyLinkedList<Key> oldFirst = first;
        oldFirst.next.prev = null;
        first = oldFirst.next;
        return;
    }
}
