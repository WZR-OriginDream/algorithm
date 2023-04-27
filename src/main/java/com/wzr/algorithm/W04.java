package com.wzr.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

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
    public void test06(){
        System.out.println(infixToSuffix("a+b*c/d"));
        System.out.println(infixToSuffix("(a+b)*c/d"));
        System.out.println(infixToSuffix("g-s*(a+b)*c/d"));
    }


    /**
     * 中缀表达式转化位后缀表达式
     * 1.遇到非运算符，直接拼串
     * 2.遇到 +，-，*，/
     *   - 它的优先级比栈顶运算符高，入栈
     *   - 否则吧栈里优先级 >= 它的都出栈，它再入栈
     * 3.遍历完成，栈里剩余元素依次出栈
     * 4.带 ()
     *   - ( 直接入栈，优先级设置为0
     *   - ) 把栈里到 ( 为止的所有运算符出栈
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
                        }else {
                            while (!stack.isEmpty() && priority(c) <= priority(stack.peek())){
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
        while (!stack.isEmpty()){
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
