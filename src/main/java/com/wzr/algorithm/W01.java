package com.wzr.algorithm;

import org.junit.Test;

/**
 * @Author:wzr
 * @Description:TODO
 * @Create:2023/2/26 - 16:32
 * @Version:v1.0
 */
public class W01 {

    /**
     * 基础版  左右双闭
     */
    public int binarySearch01(int[] a, int target) {
        int i = 0;
        int j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                return m;  //key found
            }
        }
        return -1;
    }

    /**
     * 改动版  左闭右开
     */
    public int binarySearch02(int[] a, int target) {
        int i = 0;
        int j = a.length;       //1 step
        while (i < j) {         //3 step
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m;          //2 step
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    /**
     * 平衡版
     */
    public int binarySearch03(int[] a, int target) {
        int i = 0;
        int j = a.length;
        while (i + 1 < j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m;
            } else {
                i = m;
            }
        }
        return (a[i] == target) ? i : -1;
    }


    /**
     * 插入位置
     */
    public int binaryInsert(int[] a, int target) {
        int i = 0;
        int j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                return m;  //key found
            }
        }
        return i;
    }

    /**
     * 插入位置
     */
    public int leftMost(int[] a, int target) {
        int i = 0;
        int j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target <= a[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }


    /**
     * 重复值最左
     */
    public int left(int[] a, int target) {
        int i = 0;
        int j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (target > a[m]) {
                i = m + 1;
            } else {
                candidate = m;
                j = m - 1;
            }
        }
        return candidate;
    }

    /**
     * 重复值最右
     */
    public int right(int[] a, int target) {
        int i = 0;
        int j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                candidate = m;  //key found
                i = m + 1;
            }
        }
        return candidate;
    }

    /**
     * 求任意峰值，
     * */
    public int findPeakElement (int[] nums) {
        // write code here
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else
                r = mid;
        }
        return l;
    }
}
