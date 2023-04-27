package com.wzr.algorithm;

/**
 * @Author:wzr
 * @Description:TODO
 * @Create:2023/4/27 - 10:51
 * @Version:v1.0
 */
public interface Deque<E> {
    boolean offerFirst(E e);
    boolean offerLast(E e);
    E pollFirst(E e);
    E pollLast(E e);
    E peekFirst(E e);
    E peekLast(E e);
    boolean isEmpty();
    boolean isFull();
}
