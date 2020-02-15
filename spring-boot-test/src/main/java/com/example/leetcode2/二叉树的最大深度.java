package com.example.leetcode2;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2020-02-12 12:18
 */
public class 二叉树的最大深度 {


    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(3);
        TreeNode l2 = new TreeNode(9);
        TreeNode l3 = new TreeNode(20);
        TreeNode l4 = new TreeNode(15);
        TreeNode l5 = new TreeNode(7);

        l1.left = l2;
        l1.right = l3;
        l3.left = l4;
        l3.right = l5;

        int res = new 二叉树的最大深度().maxDepth(l1);
        System.out.println(res);

    }

    int res = 0;

    public int maxDepth(TreeNode root) {

        //countHigh(root);
        doFind(1,root);

        return res;
    }

    private int countHigh(TreeNode root) {

        if(root == null){
            return 0;
        }

        return Math.max(countHigh(root.left),countHigh(root.right))+1;


    }

    private void doFind(int n, TreeNode root) {

        if(root == null){
            res = Math.max(res,n-1);
        }else {
            doFind(n+1,root.left);
            doFind(n+1,root.right);
        }

    }

}
