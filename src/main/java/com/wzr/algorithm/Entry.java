package com.wzr.algorithm;

/**
 * @Author:wzr
 * @Description:TODO
 * @Create:2023/5/6 - 15:54
 * @Version:v1.0
 */
public class Entry implements Priority{
    String val;
    int priority;

    public Entry(String val, int priority) {
        this.val = val;
        this.priority = priority;
    }

    @Override
    public int priority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "val='" + val + '\'' +
                ", priority=" + priority +
                '}';
    }
}
