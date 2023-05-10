package com.wzr.algorithm;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * @Author:wzr
 * @Description:TODO
 * @Create:2023/4/25 - 19:32
 * @Version:v1.0
 */
public class W04 {
    @Test
    public void test01() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }

    @Test
    public void test02() {
        TreeNode root = new TreeNode(
                new TreeNode(
                        new TreeNode(4),
                        2,
                        new TreeNode(5)
                ),
                1,
                new TreeNode(
                        new TreeNode(6),
                        3,
                        new TreeNode(7)
                )
        );
        System.out.println(levelOrder(root));
        System.out.println(zigzagLevelOrder(root));
    }

    @Test
    public void test03() {

        assertEquals(isValid("()"), true);
    }

    @Test
    public void test04() {
        assertEquals(evalRPN(new String[]{"2", "1", "+", "3", "*"}), 9);
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }

    @Test
    public void test05() {
        int a = 10;
        int b = 20;
        int c = a + b;
    }

    @Test
    public void test06() {
        System.out.println(infixToSuffix("a+b*c/d"));
        System.out.println(infixToSuffix("(a+b)*c/d"));
        System.out.println(infixToSuffix("g-s*(a+b)*c/d"));
    }

    @Test
    public void test07() {
        PriorityQueue1<Entry> queue1 = new PriorityQueue1<>(5);
        queue1.offer(new Entry("task1", 4));
        queue1.offer(new Entry("task2", 3));
        queue1.offer(new Entry("task3", 2));
        queue1.offer(new Entry("task4", 5));
        queue1.offer(new Entry("task5", 1));

        assertFalse(queue1.offer(new Entry("task6", 7)));

        assertEquals(5, queue1.poll().priority());
        assertEquals(4, queue1.poll().priority());
        assertEquals(3, queue1.poll().priority());
        assertEquals(2, queue1.poll().priority());
        assertEquals(1, queue1.poll().priority());
    }

    @Test
    public void test08() {
        PriorityQueue2<Entry> queue2 = new PriorityQueue2<>(5);
        queue2.offer(new Entry("task1", 4));
        queue2.offer(new Entry("task2", 3));
        queue2.offer(new Entry("task3", 2));
        queue2.offer(new Entry("task4", 5));
        queue2.offer(new Entry("task5", 1));

        assertFalse(queue2.offer(new Entry("task6", 7)));

        assertEquals(5, queue2.poll().priority());
        assertEquals(4, queue2.poll().priority());
        assertEquals(3, queue2.poll().priority());
        assertEquals(2, queue2.poll().priority());
        assertEquals(1, queue2.poll().priority());
    }

    @Test
    public void test09() {
        PriorityQueue3<Entry> queue3 = new PriorityQueue3<>(5);
        queue3.offer(new Entry("task1", 4));
        queue3.offer(new Entry("task2", 3));
        queue3.offer(new Entry("task3", 2));
        queue3.offer(new Entry("task4", 5));
        queue3.offer(new Entry("task5", 1));

        assertFalse(queue3.offer(new Entry("task6", 7)));

        assertEquals(5, queue3.poll().priority());
        assertEquals(4, queue3.poll().priority());
        assertEquals(3, queue3.poll().priority());
        assertEquals(2, queue3.poll().priority());
        assertEquals(1, queue3.poll().priority());
    }

    @Test
    public void test10() {
        ListNode[] lists = {
                ListNode.of(1, 4, 5),
                ListNode.of(1, 3, 4),
                ListNode.of(2, 6),
                null
        };
        System.out.println(mergeLists(lists));
    }

    @Test
    public void test11() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        MaxHeap maxHeap = new MaxHeap(array);
        System.out.println(Arrays.toString(maxHeap.array));
    }

    @Test
    public void test12() {
        int[] array = {2, 3, 1, 7, 6, 4, 5};
        System.out.println(Arrays.toString(heapSort(array)));
        int[] array1 = {10, 3, 1, 7, 6, 4, 50, 100, 60};
        System.out.println(Arrays.toString(heapSort(array1)));
    }

    @Test
    public void test13() {
        int[] array1 = {10, 3, 1, 7, 6, 4, 50, 60, 100, 60};
        System.out.println(findKthLargest(array1, 3));
    }

    private MinHeap heap;

    @Test
    public void test14() {
        int[] array = {4, 5, 8, 2};
        findFlowKthLargest(3, array);
        System.out.println(add(3));
        System.out.println(add(5));
    }


    private MaxHeap left = new MaxHeap(10);
    private MinHeap right = new MinHeap(10);

    //java API
    private PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(
            (a,b)->Integer.compare(b,a)
    );
    private PriorityQueue<Integer> minheap = new PriorityQueue<Integer>(
            (a,b)->Integer.compare(a,b)
    );
    @Test
    public void test15(){
        addNum(1);
        addNum(2);
        addNum(3);
        addNum(7);
        addNum(8);
        addNum(9);
        System.out.println(findMedian());
        addNum(10);
        System.out.println(findMedian());
        addNum(4);
        System.out.println(findMedian());
    }

    @Test
    public void test16(){
        MaxHeap heap = new MaxHeap(3);
        for (int i = 0; i < 10; i++) {
            heap.offer(i);
            System.out.println(Arrays.toString(heap.array));
        }
    }

    public void addNum(int num) {
        if (left.getSize() == right.getSize()) {
            right.offer(num);
            left.offer(right.poll());
        } else {
            left.offer(num);
            right.offer(left.poll());
        }
    }

    public double findMedian() {
        if (left.getSize() == right.getSize()) {
            return (left.peek() + right.peek()) / 2.0;
        }else {
            return left.peek();
        }
    }

    /**
     * 求数据流第k大元素
     */
    public void findFlowKthLargest(int k, int[] nums) {
        heap = new MinHeap(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (!heap.isFull()) {
            heap.offer(val);
        } else if (val > heap.peek()) {
            heap.replace(val);
        }
        return heap.peek();
    }

    /**
     * 求数组中第k大的元素
     * 1.向小顶堆放入前k个元素
     * 2.剩余元素
     * - 若<=堆顶元素，则略过
     * - 若>堆顶元素，则替换堆顶元素
     * 3.这样小顶堆始终保留的是到目前为止，前k大元素
     * 4.循环结束，堆顶元素即为整个数组第k大元素
     */
    public int findKthLargest(int[] nums, int k) {
        MinHeap heap = new MinHeap(k);
        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > heap.peek()) {
                heap.replace(nums[i]);
            }
        }
        return heap.peek();
    }

    /**
     * 堆排序
     * 1.heapify()建立大顶堆
     * 2.将堆顶与堆底交换(最大元素交换到堆底),缩小并下潜调整堆
     * 3.重复第二步直至堆里只剩一个元素
     */
    public int[] heapSort(int[] array) {
        MaxHeap heap = new MaxHeap(array);
        while (heap.size > 1) {
            heap.swap(0, heap.size - 1);
            heap.size--;
            heap.down(0);
        }
        return array;
    }

    /**
     * 使用小顶堆实现合并多个有序链表
     */
    public ListNode mergeLists(ListNode[] lists) {
        MinHeap1 heap = new MinHeap1(lists.length);
        //1.将链表头节点加入小顶堆
        for (ListNode h : lists) {
            if (h != null) {
                heap.offer(h);
            }
        }
        //2.不断从小顶堆移除最小元素，并加入链表
        ListNode s = new ListNode(-1, null);
        ListNode t = s;
        while (!heap.isEmpty()) {
            ListNode min = heap.poll();
            t.next = min;
            t = min;
            if (min.next != null) {
                heap.offer(min.next);
            }
        }
        return s.next;
    }

    /**
     * 中缀表达式转化位后缀表达式
     * 1.遇到非运算符，直接拼串
     * 2.遇到 +，-，*，/
     * - 它的优先级比栈顶运算符高，入栈
     * - 否则吧栈里优先级 >= 它的都出栈，它再入栈
     * 3.遍历完成，栈里剩余元素依次出栈
     * 4.带 ()
     * - ( 直接入栈，优先级设置为0
     * - ) 把栈里到 ( 为止的所有运算符出栈
     */
    public String infixToSuffix(String exp) {
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder(exp.length());
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            switch (c) {
                case '+', '-', '*', '/' -> {
                    if (stack.isEmpty()) {
                        stack.push(c);
                    } else {
                        if (priority(c) > priority(stack.peek())) {
                            stack.push(c);
                        } else {
                            while (!stack.isEmpty() && priority(c) <= priority(stack.peek())) {
                                sb.append(stack.pop());
                            }
                            stack.push(c);
                        }

                    }
                }
                case '(' -> stack.push(c);
                case ')' -> {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                }
                default -> sb.append(c);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    static int priority(char c) {
        return switch (c) {
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            case '(' -> 0;
            default -> throw new IllegalArgumentException("Invalid");
        };
    }

    /**
     * 逆波兰表达式（后缀表达式）求值
     */
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a + b);
                }
                case "-" -> {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a - b);
                }
                case "*" -> {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a * b);
                }
                case "/" -> {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a / b);
                }
                default -> { //数字
                    stack.push(Integer.parseInt(token));
                }
            }
        }
        return stack.pop();
    }

    /**
     * 有效的括号
     */
    public boolean isValid(String s) {
        ArrayStack<Character> stack = new ArrayStack<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                if (!stack.isEmpty() && c == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * 二叉树Z字层序遍历
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        queue.offer(root);
        int c1 = 1;
        boolean odd = true;
        while (!queue.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();
            int c2 = 0;
            for (int i = 0; i < c1; i++) {
                TreeNode node = queue.poll();
                if (odd) {
                    level.offerLast(node.val);
                } else {
                    level.offerFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                    c2++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    c2++;
                }
            }
            odd = !odd;
            result.add(level);
            c1 = c2;
        }
        return result;
    }

    /**
     * 二叉树层序遍历
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        queue.offer(root);
        int c1 = 1;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int c2 = 0;
            for (int i = 0; i < c1; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                    c2++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    c2++;
                }
            }
            result.add(level);
            c1 = c2;
        }
        return result;
    }
}
