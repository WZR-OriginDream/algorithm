package com.wzr.algorithm;

import java.util.Iterator;

/**
 * @Author:wzr
 * @Description:TODO
 * @Create:2023/4/25 - 20:46
 * @Version:v1.0
 */
public class ArrayQueue1<E> implements Queue<E>, Iterable<E> {
    private E[] array;
    private int head = 0;
    private int tail = 0;
    private int size = 0; //元素个数

    public ArrayQueue1(int capacity) {
        array = (E[]) new Object[capacity + 1];
    }

    @Override
    public boolean offer(E val) {
        if (isFull()) return false;
        array[tail] = val;
        tail=(tail + 1) % array.length;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        E val = array[head];
        head = (head + 1) % array.length;
        size--;
        return val;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return array[head];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
//        return size==0;
    }

    @Override
    public boolean isFull() {
        return (tail + 1) % array.length == head;
//        return size == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;
//            int count =0;

            @Override
            public boolean hasNext() {
                return p != tail;
//                return count < size;
            }

            @Override
            public E next() {
                E val = array[p];
                p = (p + 1) % array.length;
//                count++;
                return val;
            }
        };
    }
}
