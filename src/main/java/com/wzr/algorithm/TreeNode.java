package com.wzr.algorithm;

/**
 * @Author:wzr
 * @Description:TODO
 * @Create:2023/4/26 - 10:42
 * @Version:v1.0
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(TreeNode left, int val, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}
