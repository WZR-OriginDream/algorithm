package com.wzr.algorithm;

import java.util.Iterator;

/**
 * @Author:wzr
 * @Description:TODO
 * @Create:2023/4/26 - 12:17
 * @Version:v1.0
 */
public class ArrayStack<E> implements Stack<E>, Iterable<E> {
    private E[] array;
    private int top;

    @SuppressWarnings("all")
    public ArrayStack(int capacity) {
        this.array = (E[]) new Object[capacity];
    }

    @Override
    public boolean push(E e) {
        if (isFull()) {
            return false;
        }
        array[top++] = e;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        return array[--top];
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean isFull() {
        return top == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = top;

            @Override
            public boolean hasNext() {
                return p > 0;
            }

            @Override
            public E next() {
                return array[--p];
            }
        };
    }
}
