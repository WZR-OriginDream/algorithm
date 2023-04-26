package com.wzr.algorithm;

/**
 * @Author:wzr
 * @Description:TODO
 * @Create:2023/4/25 - 19:44
 * @Version:v1.0
 */
public interface Queue<E> {
    /**
     * @param val
     * @return bool
     * */
    boolean offer(E val);
    /**
     * 返回头元素值并删除头元素
     * */
    E poll();
    /**
     * 返回头元素值
     * */
    E peek();
    boolean isEmpty();
    /**
     * 检查队列是否已满
     * @return bool
     * */
    boolean isFull();
}
