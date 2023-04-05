package com.wzr.algorithm;

import java.util.Iterator;

/**
 * @Author:wzr
 * @Description:TODO
 * @Create:2023/4/5 - 12:02
 * @Version:v1.0
 */
public class DoublyLinkedListSentinel implements Iterable<Integer> {

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public Integer next() {
                int val = p.val;
                p = p.next;
                return val;
            }
        };
    }

    static class Node {
        Node prev;
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(Node prev, int val, Node next) {
            this.prev = prev;
            this.val = val;
            this.next = next;
        }

    }

    private Node head;
    private Node tail;

    public DoublyLinkedListSentinel() {
        head = new Node(null, 0, null);
        tail = new Node(null, -1, null);
        head.next = tail;
        tail.prev = head;
    }

    public Node get(int index) {
        int i = -1;
        for (Node p = head; p != tail; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    public void insert(int index, int val) {
        Node prev = get(index - 1);
        if (prev == null) {
            throw new IllegalArgumentException("index out");
        }
        Node next = prev.next;
        Node p = new Node(prev, val, next);
        next.prev = p;
        prev.next = p;
    }

    public void remove(int index) {
        Node prev = get(index - 1);
        if (prev == null || prev.next == tail) {
            throw new IllegalArgumentException("index out");
        }
        Node removed = prev.next;
        Node next = removed.next;
        next.prev = prev.next;
        prev.next = next.prev;
    }

    public void addLast(int val) {
        Node last = tail.prev;
        Node added = new Node(last, val, tail);
        last.next = added;
        tail.prev = added;
    }

    public void removeLast() {
        Node last = tail.prev;
        if (last == head) {
            throw new IllegalArgumentException("0");
        }
        Node prev = last.prev;
        prev.next = tail;
        tail.prev = prev;
    }
}
