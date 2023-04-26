package com.wzr.algorithm;

/**
 * @Author:wzr
 * @Description:TODO
 * @Create:2023/4/26 - 11:40
 * @Version:v1.0
 */
public interface Stack<E> {
    /**
     * 向栈顶压入元素
     * */
    boolean push(E e);

    /**
     * 从栈顶弹出元素
     * */
    E pop();

    /**
     * 返回栈顶元素，不弹出
     * */
    E peek();

    /**
     * 判断栈是否为空
     * */
    boolean isEmpty();

    /**
     * 判断栈是否已满
     * */
    boolean isFull();

}
