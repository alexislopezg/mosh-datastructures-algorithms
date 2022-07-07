package DataStructures;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void addFirst(int item) {
        var node = new Node(item);
        if (isEmpty())
            first = last = node;
        else
            first = first.next = node;
        size++;
    }

    public void addLast(int item) {
        var node = new Node(item);
        if (isEmpty()) // Empty list
            first = last = node;
        else  // List has at least one node/item
            last = last.next = node;
        size++;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public int indexOf(int item) {
        var index = 0;
        var current = first;
        while (current != null) {
            if (item == current.value)
                return index;
            else {
                index++;
                current = current.next;
            }
        }
        return -1;
    }

    public boolean contains(int item) {
        // Better solution : return indexOf(item) != -1
        var current = first;
        while (current != null) {
            if (item == current.value)
                return true;
            current = current.next;
        }
        return false;
    }

    public void removeFirst() {
        //[10 -> 20 -> 30]
        //Set head to point second node
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
            size = 0;
            return;
        }
        var second = first.next;
        //Remove the reference to the previous head
        first.next = null;
        first = second;

        size--;
    }

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        if (first == last) {
            first = last = null;
            size = 0;
            return;
        }
        last = getPrevious(last);
        last.next = null;


    }

    private Node getPrevious(Node node) {
        var current = first;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    public int size() {
        return size;
    }
}
