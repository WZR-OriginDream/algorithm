package com.wzr.algorithm;

import org.junit.Test;

/**
 * @Author:wzr
 * @Description:TODO
 * @Create:2023/3/29 - 16:31
 * @Version:v1.0
 */
public class W03 {
    @Test
    public void test() {
//        ListNode p6=new ListNode(6,null);
//        ListNode p5=new ListNode(5,p6);
//        ListNode p4=new ListNode(4,p5);
//        ListNode p3=new ListNode(3,p4);
//        ListNode p2=new ListNode(2,p3);
//        ListNode p1=new ListNode(1,p2);
//        p6.next =p5;
//        ListNode o1 = ListNode.of(1, 2, 2, 1);
//        ListNode o2 = ListNode.of(2, 9, 11);
//        ListNode o3 = ListNode.of(3, 5);
//        ListNode[] lists = {o1, o2, o3};
//        System.out.println(detectCycle(p1).val);
        ListNode p= null;
        System.out.println(p.next);
    }

    /**
     * 检测链表的回环入口
     * */
    public ListNode detectCycle(ListNode head){
        ListNode r= head;
        ListNode t =head;
        while (r!=null&& r.next!= null){
            t=t.next;
            r=r.next.next;
            if (r==t){
                t=head;
                while (r!=t){
                    t=t.next;
                    r=r.next;
                }
                return t;
            }
        }
        return null;
    }
    /**
     * 判断链表回环
     * */
    public boolean hasCycle(ListNode head) {
        ListNode r= head;
        ListNode t =head;
        while (r!=null&& r.next!= null){
            t=t.next;
            r=r.next.next;
            if (r==t){
                return true;
            }
        }
        return false;
    }

    /**
     * 回文链表
     * 优化
     */
    public boolean isPairindrome2(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode n1 = null;
        ListNode o1 = head, o2;
        while (p2 != null && p2.next != null) {
            //快慢指针获取中间节点
            p1 = p1.next;
            p2 = p2.next.next;

            //反转中间节点之前的链表
            o1.next = n1;
            n1 = o1;
            o1 = p1;
        }
        //奇数中点则p2不为null,回文比较时跳过
        if (p2 != null) {
            p1 = p1.next;
        }
        while (n1 != null) {
            if (n1.val != p1.val) {
                return false;
            }
            n1 = n1.next;
            p1 = p1.next;
        }
        return true;
    }

    /**
     * 回文链表
     */
    public boolean isPairindrome1(ListNode head) {
        ListNode middle = middleNode(head);
        ListNode p = reverseList5(middle);
        while (p != null) {
            if (p.val != head.val) {
                return false;
            }
            p = p.next;
            head = head.next;
        }
        return true;
    }

    /**
     * 查找中间节点
     * 快慢指针法
     */
    public ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    /**
     * 合并多个有序链表
     * 递归法
     */
    public ListNode mergeTwoLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return split(lists, 0, lists.length - 1);
    }

    private ListNode split(ListNode[] lists, int i, int j) {
        if (i == j) {
            return lists[i];
        }
        int m = (i + j) >>> 1;
        ListNode left = split(lists, i, m);
        ListNode right = split(lists, m + 1, j);
        return mergeTwoLists1(left, right);
    }

    /**
     * 合并有序链表
     * 递归法
     */
    public ListNode mergeTwoLists2(ListNode o1, ListNode o2) {
        if (o1 == null) {
            return o2;
        }
        if (o2 == null) {
            return o1;
        }
        if (o1.val <= o2.val) {
            o1.next = mergeTwoLists2(o1.next, o2);
            return o1;
        } else {
            o2.next = mergeTwoLists2(o1, o2.next);
            return o2;
        }

    }


    /**
     * 合并有序链表
     * 非递归法
     */
    public ListNode mergeTwoLists1(ListNode o1, ListNode o2) {
        if (o1 == null) {
            return o2;
        }
        if (o2 == null) {
            return o1;
        }
        ListNode s = new ListNode(0, null);
        ListNode p = s;
        while (o1 != null && o2 != null) {
            if (o1.val <= o2.val) {
                p.next = o1;
                o1 = o1.next;
            } else {
                p.next = o2;
                o2 = o2.next;
            }
            p = p.next;
        }
        if (o1 != null) {
            p.next = o1;
        }
        if (o2 != null) {
            p.next = o2;
        }
        return s.next;
    }

    /**
     * 有序链表去重,保留一个
     */
    public ListNode deleteDuplicateNode1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head;
        while (p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }

    /**
     * 有序链表去重,保留一个
     * 递归法
     */
    public ListNode deleteDuplicateNode2(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.val == head.next.val) {
            return deleteDuplicateNode2(head.next);
        } else {
            head.next = deleteDuplicateNode2(head.next);
            return head;
        }
    }

    /**
     * 有序链表去重，全部删除
     * 递归法
     */
    public ListNode deleteDuplicateNode3(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.val == head.next.val) {
            ListNode x = head.next.next;
            while (x != null && x.val == head.val) {
                x = x.next;
            }
            return deleteDuplicateNode3(x);
        } else {
            head.next = deleteDuplicateNode3(head.next);
            return head;
        }
    }

    /**
     * 有序链表去重，全部删除
     * 非递归法
     */
    public ListNode deleteDuplicateNode4(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode s = new ListNode(0, head);
        ListNode p1 = s;
        ListNode p2, p3;
        while ((p2 = p1.next) != null && (p3 = p2.next) != null) {
            if (p2.val == p3.val) {
                while ((p3 = p3.next) != null && p2.val == p3.val) {
                }
                p1.next = p3;
            } else {
                p1 = p1.next;
            }
        }
        return s.next;
    }

    /**
     * 反转单向链表
     * 头插法
     */
    public ListNode reverseList1(ListNode o1) {
        ListNode n1 = null;
        while (o1 != null) {
            n1 = new ListNode(o1.val, n1);
            o1 = o1.next;
        }
        return n1;
    }

    /**
     * 反转单向链表
     * 移动法
     */
    public ListNode reverseList2(ListNode head) {
        List list1 = new List(head);
        List list2 = new List(null);
        while (list1.head != null) {
            list2.addFirst(list1.removeFirst());
        }
        return list2.head;
    }

    static class List {
        private ListNode head;

        public List(ListNode head) {
            this.head = head;
        }

        public void addFirst(ListNode first) {
            first.next = head;
            head = first;
        }

        public ListNode removeFirst() {
            ListNode first = head;
            if (first != null) {
                head = first.next;
            }
            return first;
        }
    }

    /**
     * 反转单向链表
     * 递归法
     */
    public ListNode reverseList3(ListNode head) {
        //特殊情况和临界条件
        if (head == null || head.next == null) {
            return head;
        }
        //递归体
        ListNode last = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 反转单向链表
     * 移2法
     */
    public ListNode reverseList4(ListNode o1) {
        //特殊情况和临界条件
        if (o1 == null || o1.next == null) {
            return o1;
        }
        ListNode n1 = o1;
        ListNode o2 = o1.next;
        while (o2 != null) {
            o1.next = o2.next;
            o2.next = n1;
            n1 = o2;
            o2 = o1.next;
        }
        return n1;
    }


    /**
     * 反转单向链表
     * 移动法
     */
    public ListNode reverseList5(ListNode o1) {
        //特殊情况和临界条件
        if (o1 == null || o1.next == null) {
            return o1;
        }
        ListNode n1 = null;
        ListNode o2;
        while (o1 != null) {
            o2 = o1.next;
            o1.next = n1;
            n1 = o1;
            o1 = o2;
        }
        return n1;
    }

    /**
     * 删除节点
     * 双指针法
     */
    public ListNode deleteNode1(ListNode head, int val) {
        ListNode p = new ListNode(0, head);
        ListNode prev = p;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return p.next;
    }

    /**
     * 删除节点
     * 递归法
     */
    public ListNode deleteNode2(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode p = deleteNode2(head.next, val);
        if (head.val == val) {
            return p;
        } else {
            head.next = p;
            return head;
        }
    }

    /**
     * 删除倒数n节点(n=1,..)
     * 递归法
     */
    public ListNode deleteNode3(ListNode head, int n) {
        ListNode s = new ListNode(0, head);
        recursion(s, n);
        return s.next;
    }

    public int recursion(ListNode head, int n) {
        if (head == null) {
            return 0;
        }
        int nth = recursion(head.next, n);
        if (nth == n) {
            head.next = head.next.next;
        }
        return nth + 1;
    }

    /**
     * 删除倒数n节点(n=1,..)
     * 滑动窗口法
     */
    public ListNode deleteNode4(ListNode head, int n) {
        ListNode s = new ListNode(0, head);
        ListNode p1 = s;
        ListNode p2 = s;
        for (int i = 0; i <= n; i++) {
            p2 = p2.next;
        }
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return s.next;
    }
}
