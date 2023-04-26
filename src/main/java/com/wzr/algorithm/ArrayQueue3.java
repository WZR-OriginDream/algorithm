package com.wzr.algorithm;

import java.util.Iterator;

/**
 * @Author:wzr
 * @Description:TODO
 * @Create:2023/4/25 - 20:47
 * @Version:v1.0
 */
public class ArrayQueue3<E> implements Queue<E>, Iterable<E> {

    /*
        求模运算：
        - 如果除数是2的n次方
        - 那么被除数后n位即为余数（模）
        - 求被除数后n位方法：与2^n-1按位与
    */
    private E[] array;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue3(int c) {
//        if ((c & c-1)!=0){
//            throw new IllegalArgumentException("capacity must be 2^n");
//        }
//      (1)将c改成最近的比c大的2^n
//        int n = (int) ((Math.log10(c-1)/Math.log10(2))+1);
//        c=1<<n;
//      (2)将c改成最近的比c大的2^n
        c-=1;
        c|=c>>1;
        c|=c>>2;
        c|=c>>4;
        c|=c>>8;
        c|=c>>16;
        c+=1;
        array = (E[]) new Object[c];
    }

    @Override
    public boolean offer(E val) {
        if (isFull()) return false;
        array[tail & (array.length-1)] = val;
        tail++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        E val = array[head & array.length-1];
        head++;
        return val;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return array[head & array.length-1];
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
                E val = array[p & array.length-1];
                p++;
                return val;
            }
        };
    }
}
