package com.wzr.algorithm;

/**
 * @Author:wzr
 * @Description:TODO
 * @Create:2023/4/27 - 22:51
 * @Version:v1.0
 */
public class PriorityQueue3<E extends Priority> implements Queue<E> {
    Priority[] array;
    int size;

    public PriorityQueue3(int capacity) {
        array = new Priority[capacity];
    }

    /**
     * 1.入堆新元素，加入到数组末尾（索引位置child）
     * 2.(上浮)
     * 不断比较新加元素与其父节点(parent)优先级
     * - 如果父节点优先级低，则向下移动，并找到下一个parent
     * - 直至父节点优先级更高或child == 0 为止
     */
    @Override
    public boolean offer(E e) {
        if (isFull()) return false;
        int child = size++;
        int parent = (child - 1) / 2;
        while (child > 0 && e.priority() > array[parent].priority()) {
            array[child] = array[parent];
            child = parent;
            parent = (child - 1) / 2;
        }
        array[child] = e;
        return true;
    }

    /**
     * 1.交换堆顶和尾部元素，让尾部元素出堆(避免数组大规模移动，降低时间复杂度)
     * 2.(下潜)
     * - 从堆顶开始，将父元素与左右两个孩子较大者交换
     * - 直到父元素大于两个孩子，或没有孩子为止
     */
    @Override
    public E poll() {
        if (isEmpty()) return null;
        swap(0, size - 1);
        size--;
        E e = (E) array[size];
        array[size] = null; //help GC
        down(0);
        return e;
    }

    private void swap(int i, int j) {
        Priority temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void down(int parent) {
        int left = 2 * parent + 1;
        int right = left + 1;
        int max = parent;
        if (left < size && array[left].priority() > array[max].priority()) {
            max = left;
        }
        if (right < size && array[right].priority() > array[max].priority()) {
            max = right;
        }
        if (max != parent) {
            swap(max, parent);
            down(max);
        }
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return (E) array[0];
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
