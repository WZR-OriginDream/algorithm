package com.wzr.algorithm;

import java.util.Iterator;

/**
 * @Author:wzr
 * @Description:TODO
 * @Create:2023/4/27 - 10:48
 * @Version:v1.0
 */
public class LinkedListDeque<E> implements Deque<E>, Iterable {

    int capacity;
    int size;
    Node<E> sentinel = new Node<>(null, null, null);

    public LinkedListDeque(int capacity) {
        this.capacity = capacity;
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    @Override
    public boolean offerFirst(E e) {
        if (isFull()) return false;
        Node<E> a = sentinel;
        Node<E> b = sentinel.next;
        Node<E> added = new Node<>(a,e,b);
        a.next =added;
        b.prev =added;
        size++;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if (isFull()) return false;
        Node<E> a = sentinel.prev;
        Node<E> b = sentinel;
        Node<E> added = new Node<>(a,e,b);
        a.next =added;
        b.prev =added;
        size++;
        return true;
    }

    @Override
    public E pollFirst(E e) {
        if (isEmpty()) return null;
        Node<E> a = sentinel;
        Node<E> removed = sentinel.next;
        Node<E> b = removed.next;
        a.next =b;
        b.prev =a;
        size--;
        return removed.val;
    }

    @Override
    public E pollLast(E e) {
        if (isEmpty()) return null;
        Node<E> a = sentinel;
        Node<E> removed = sentinel.prev;
        Node<E> b = removed.prev;
        a.prev =b;
        b.next =a;
        size--;
        return removed.val;
    }

    @Override
    public E peekFirst(E e) {
        if (isEmpty()) return null;
        return sentinel.next.val;
    }

    @Override
    public E peekLast(E e) {
        if (isEmpty()) return null;
        return sentinel.prev.val;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            Node<E> p = sentinel.next;
            @Override
            public boolean hasNext() {
                return p!=sentinel;
            }

            @Override
            public Object next() {
                E val = p.val;
                p = p.next;
                return val;
            }
        };
    }

    static class Node<E> {
        Node<E> prev;
        E val;
        Node<E> next;

        public Node(Node<E> prev, E val, Node<E> next) {
            this.prev = prev;
            this.val = val;
            this.next = next;
        }
    }
}
