package com.wzr.algorithm;

import java.util.Iterator;

/**
 * @Author:wzr
 * @Description:TODO
 * @Create:2023/4/26 - 11:53
 * @Version:v1.0
 */
public class LinkedListStack<E> implements Stack<E>,Iterable<E>{
    private int capacity;
    private int size;
    private Node<E> head = new Node<>(null,null);

    public LinkedListStack(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean push(E e) {
        if (isFull()) {return false;}
        head.next = new Node<E>(e,head.next);
        size++;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {return null;}
        Node<E> first = head.next;
        head.next = first.next;
        size--;
        return first.val;
    }

    @Override
    public E peek() {
        if (isEmpty()) {return null;}
        return head.next.val;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean isFull() {
        return size==capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = head.next;
            @Override
            public boolean hasNext() {
                return p!=null;
            }

            @Override
            public E next() {
                E e = p.val;
                p = p.next;
                return e;
            }
        };
    }

    static class Node<E> {
        E val;
        Node<E> next;

        public Node(E val, Node<E> next) {
            this.val = val;
            this.next = next;
        }
    }
}
