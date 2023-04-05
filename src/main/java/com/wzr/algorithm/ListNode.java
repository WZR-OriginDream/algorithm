package com.wzr.algorithm;

/**
 * @Author:wzr
 * @Description:TODO
 * @Create:2023/3/29 - 16:38
 * @Version:v1.0
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode of(int... items){
        ListNode s = new ListNode(0,null);
        ListNode p = s;
        for (int item:items) {
            ListNode n = new ListNode(item,null);
            p.next = n;
            p = p.next;
        }
        return s.next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("[");
        ListNode p =this;
        while (p != null) {
            sb.append(p.val);
            if (p.next != null){
                sb.append(",");
            }
            p = p.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
