package com.wzr.algorithm;

/**
 * @Author:wzr
 * @Description:TODO
 * @Create:2023/4/27 - 22:51
 * @Version:v1.0
 */
public class PriorityQueue1<E extends Priority> implements Queue<E> {
    Priority[] array;
    int size;

    public PriorityQueue1(int capacity){
        array = new Priority[capacity];
    }

    @Override  //O(1)
    public boolean offer(E val) {
        if (isFull()) return false;
        array[size++] = val;
        return true;
    }

    private int selectMax(){
        int max = 0;
        for (int i = 0; i < size; i++) {
            if (array[i].priority() > array[max].priority()){
                max = i;
            }
        }
        return max;
    }

    @Override //O(n)
    public E poll() {
        if (isEmpty()) return null;
        int max = selectMax();
        E e = (E) array[max];
        remove(max);
        return e;
    }

    private void remove(int index) {
        if (index < size-1){
            System.arraycopy(array,index+1,array,index,size-1-index);
        }
        size--;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        int max = selectMax();
        return (E) array[max];
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
