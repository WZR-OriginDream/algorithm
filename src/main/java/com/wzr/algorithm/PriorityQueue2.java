package com.wzr.algorithm;

/**
 * @Author:wzr
 * @Description:TODO
 * @Create:2023/4/27 - 22:51
 * @Version:v1.0
 */
public class PriorityQueue2<E extends Priority> implements Queue<E> {
    Priority[] array;
    int size;

    public PriorityQueue2(int capacity) {
        array = new Priority[capacity];
    }

    @Override
    public boolean offer(E val) {
        if (isFull()) return false;
        insert(val);
        size++;
        return true;
    }

    private void insert(E e) {
        int i = size-1;
        while (i >= 0 && array[i].priority() > e.priority()) {
            array[i+1] = array[i];
            i--;
        }
        array[i+1] = e;
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        E e = (E) array[size - 1];
        array[--size] = null; //help GC
        return e;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return (E) array[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }
}
