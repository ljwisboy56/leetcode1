package com.example.leetcode2;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2020-02-12 11:37
 */
public class 对称二叉树 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode right = new TreeNode(1);

        root.left = null;
        root.right = right;

        boolean res = new 对称二叉树().isSymmetric(root);
        System.out.println(res);


    }


    public boolean isSymmetric(TreeNode root) {

        if (root == null){
            return true;
        }

        return doJudgeSymmetric(root.left,root.right);

    }

    private boolean doJudgeSymmetric(TreeNode left, TreeNode right) {

        if(left == null && right != null){
            return false;
        }

        if(left != null && right == null){
            return false;
        }

        if(left == null && right == null){
            return true;
        }

        boolean res = false;

        res = left.val == right.val;

        if(res){
            res = doJudgeSymmetric(left.right,right.left);
        }

        if(res){
            res = doJudgeSymmetric(left.left,right.right);
        }

        return res;

    }

}
