package com.wzr.algorithm;

/**
 * @Author:wzr
 * @Description:TODO
 * @Create:2023/4/27 - 19:52
 * @Version:v1.0
 */
public class ArrayDeque1<E> implements Deque<E>,Iterable<E> {


    static int inc(int i, int length){
        if (++i > length-1) return 0;
        return i;
    }

    static int dec(int i, int length){
        if (--i < 0) return length-1;
        return i;
    }
}
