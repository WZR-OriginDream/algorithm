package com.wzr.algorithm;

import org.junit.Test;

import java.beans.Introspector;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author:wzr
 * @Description:递归
 * @Create:2023/3/2 - 15:21
 * @Version:v1.0
 */
public class W02 {
    static LinkedList<Integer> a=new LinkedList<>();
    static LinkedList<Integer> b=new LinkedList<>();
    static LinkedList<Integer> c=new LinkedList<>();
    @Test
    public void testhanoi() {
        init(3);
        print();
        hanoi(3,a,b,c);
    }

    @Test
    public void testyanghui() {
        int[] a=new int[]{1, 4, 6, 4, 1};
        System.out.println(Arrays.toString(elementRow(a)));
    }
    /**
     * 杨辉三角
     * 普通实现
     * */
    public int element(int i, int j) {
        if (j == 0|| j == i){
            return 1;
        }
        return element(i-1 , j-1) + element(i-1 , j);
    }

    /**
     * 杨辉三角
     * 记忆法实现
     * */
    public int elementMemory(int[][] cache,int i, int j) {
        if (cache[i][j]>0){
            return cache[i][j];
        }
        if (j == 0|| j == i){
            cache[i][j] = 1;
            return 1;
        }
        cache[i][j]  = elementMemory(cache,i - 1, j - 1) + elementMemory(cache, i - 1, j);
        return cache[i][j];
    }

    /**
     * 杨辉三角
     * 按上行取下行
     * */
    public  int[] elementRow(int[] uprow){
        int i=uprow.length;
        int[] downrow = new int[i+1];
        downrow[0]=1;
        downrow[i]=1;
        for (int j = i-1; j > 0 ; j--) {
            downrow[j]=uprow[j]+ uprow[j-1];
        }
        return downrow;
    }



    /**
     * 汉诺塔问题
     * */
    public void hanoi(int n,LinkedList<Integer> a, LinkedList<Integer> b, LinkedList<Integer> c){
        if (n == 0) return;
        hanoi(n-1,a,c,b);
        c.addLast(a.removeLast());
        print();
        hanoi(n-1,b,a,c);
    }
    public void print() {
        System.out.println("--------------------------------");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
    public void init(int n) {
        for (int i = n; i > 0; i--) {
            a.addLast(i);
        }
    }

    /**
     * 优化递归 ，时间复杂度：未优化O(1.618^n)  优化后O(n)
     */
    public int fibonacci(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;
        return f(n, cache);
    }

    public int f(int n, int[] cache) {
        if (cache[n] != -1) {
            return cache[n];
        }
        cache[n] = f(n - 1, cache) + f(n - 2, cache);
        return cache[n];
    }
    /**
     * 递归可解决问题：跳楼梯、生兔子
     * */

    /**
     * 斐波那契数列和
     */
    public int fibSum(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n) + fibSum(n - 1);
    }

    /**
     * 斐波那契数列
     */
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 递归实现插入排序
     */
    public void insert(int[] a, int low) {
        if (low == a.length) return;
        int t = a[low];
        int i = low - 1;
        while (i >= 0 && a[i] > t) {
            a[i + 1] = a[i];
            i--;
        }
        a[i + 1] = t;
        insert(a, low + 1);
    }

    /**
     * 递归实现冒泡排序
     */
    public void bubble(int[] a, int j) {
        if (j == 0) return;
        int x = 0;
        for (int i = 0; i < j; i++) {
            if (a[i] > a[i + 1]) {
                int t = a[i];
                a[i] = a[i + 1];
                a[i + 1] = t;
                x = i;
            }
            bubble(a, x);
        }
    }

    /**
     * 递归实现二分查找
     */
    public int f3(int target, int[] nums, int i, int j) {
        if (i > j) {
            return -1;
        }

        int m = (i + j) >>> 1;
        if (target < nums[m]) {
            return f3(target, nums, i, m - 1);
        } else if (nums[m] < target) {
            return f3(target, nums, m - 1, j);
        } else {
            return m;
        }
    }

    /**
     * 阶乘
     */
    public int f1(int n) {
        if (n == 0 || n == 1) return 1;
        return n * f1(n - 1);
    }

    /**
     * 逆向打印字符串
     */
    public void f2(int n, String str) {
        if (n == str.length()) return;
        f2(n + 1, str);
        System.out.print(str.charAt(n));
    }

}
