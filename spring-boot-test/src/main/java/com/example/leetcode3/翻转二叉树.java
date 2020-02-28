package com.example.leetcode3;

import apple.laf.JRSUIUtils;
import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2020-02-27 20:26
 */
public class 翻转二叉树 {

    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        TreeNode l3 = new TreeNode(3);
        TreeNode l4 = new TreeNode(4);
        TreeNode l5 = new TreeNode(5);
        TreeNode l6 = new TreeNode(6);

        l1.left = l2;
        l1.right = l3;
        l2.left = l4;
        l2.right = l5;
        l3.left = l6;

        TreeNode root = new 翻转二叉树().invertTree(l1);
        System.out.println(root);

    }

    public TreeNode invertTree(TreeNode root) {

        if(root == null){
            return null;
        }

        if(root.left == null && root.right == null){
            return root;
        }

        TreeNode left = invertTree(root.left);

        TreeNode right = invertTree(root.right);

        root.right = left;

        root.left = right;


        return root;

    }

}
