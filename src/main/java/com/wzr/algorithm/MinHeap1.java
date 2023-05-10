package com.wzr.algorithm;

/**
 * @Author:wzr
 * @Description:TODO
 * @Create:2023/5/6 - 23:07
 * @Version:v1.0
 */
public class MinHeap1 {

    ListNode[] array;
    int size;

    public MinHeap1(int capacity) {
        array = new ListNode[capacity];
    }

    public boolean offer(ListNode offered) {
        if (isFull()) return false;
        int child = size++;
        int parent = (child - 1) / 2;
        while (child > 0 && offered.val < array[parent].val) {
            array[child] = array[parent];
            child = parent;
            parent = (child - 1) / 2;
        }
        array[child] = offered;
        return true;
    }

    /**
     * 1.交换堆顶和尾部元素，让尾部元素出堆(避免数组大规模移动，降低时间复杂度)
     * 2.(下潜)
     * - 从堆顶开始，将父元素与左右两个孩子较大者交换
     * - 直到父元素大于两个孩子，或没有孩子为止
     */
    public ListNode poll() {
        if (isEmpty()) return null;
        swap(0, size - 1);
        size--;
        ListNode e = array[size];
        array[size] = null; //help GC
        down(0);
        return e;
    }

    private void swap(int i, int j) {
        ListNode temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void down(int parent) {
        int left = 2 * parent + 1;
        int right = left + 1;
        int min = parent;
        if (left < size && array[left].val < array[min].val) {
            min = left;
        }
        if (right < size && array[right].val < array[min].val) {
            min = right;
        }
        if (min != parent) {
            swap(min, parent);
            down(min);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }
}
