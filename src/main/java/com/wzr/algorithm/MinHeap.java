package com.wzr.algorithm;

/**
 * @Author:wzr
 * @Description:TODO
 * @Create:2023/5/8 - 17:25
 * @Version:v1.0
 */
public class MinHeap {
    int[] array;
    int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public MinHeap(int capacity) {
        this.array = new int[capacity];
    }

    public MinHeap(int[] array) {
        this.array = array;
        this.size = array.length;
        heapify();
    }

    private void heapify() {
        // 如何找到最后的非叶子节点 size/2-1
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(i);
        }
    }

    public int poll() {
        if (size == 0) return -1;
        int e = array[0];
        swap(0, size - 1);
        size--;
        down(0);
        return e;
    }

    public int poll(int index) {
        if (size == 0) return -1;
        int e = array[index];
        swap(index, size - 1);
        size--;
        down(index);
        return e;
    }

    public int peek() {
        return array[0];
    }

    public void replace(int replaced) {
        array[0] = replaced;
        down(0);
    }

    public boolean offer(int offered) {
        if (isFull()) {
            grow(); //扩容
        }
        up(offered);
        size++;
        return true;
    }

    public boolean isFull(){
        return size == array.length;
    }

    /**
     * 上浮:
     * 将元素与其父亲节点比较，比父亲节点大则将父亲节点赋值给子节点，直至比父亲节点小或是索引为0
     */
    private void up(int offered) {
        int child = size;
        while (child > 0) {
            int parent = (child - 1) / 2;
            if (offered < array[parent]) {
                array[child] = array[parent];
            }else {
                break;
            }
            child = parent;
        }
        array[child] = offered;
    }

    /**
     * 下潜:
     * 将parent索引处的元素与两个孩子较小者交换，直至没孩子或孩子没它小
     */
    public void down(int parent) {
        int left = parent * 2 + 1;
        int right = left + 1;
        int min = parent;
        if (left < size && array[min] > array[left]) {
            min = left;
        }
        if (right < size && array[min] > array[right]) {
            min = right;
        }
        if (min != parent) {
            swap(min, parent);
            down(min);
        }

    }

    public void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void grow() {
        int capacity = size + (size >> 1);
        int[] newArray = new int[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

}
