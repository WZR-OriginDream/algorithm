package com.wzr.algorithm;

import java.util.Iterator;

/**
 * @Author:wzr
 * @Description:TODO
 * @Create:2023/4/25 - 20:47
 * @Version:v1.0
 */
public class ArrayQueue2<E> implements Queue<E>, Iterable<E> {
    private E[] array;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue2(int capacity) {
        array = (E[]) new Object[capacity];
    }

    @Override
    public boolean offer(E val) {
        if (isFull()) return false;
        array[(int) (Integer.toUnsignedLong(tail) % array.length)] = val;
        tail++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        E val = array[(int) (Integer.toUnsignedLong(head) % array.length)];
        head++;
        return val;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return array[(int) (Integer.toUnsignedLong(head) % array.length)];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return tail - head == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E val = array[(int) (Integer.toUnsignedLong(p) % array.length)];
                p++;
                return val;
            }
        };
    }
}
