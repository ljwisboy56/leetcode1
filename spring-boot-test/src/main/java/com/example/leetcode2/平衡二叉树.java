package com.example.leetcode2;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2020-02-12 19:04
 */
public class 平衡二叉树 {

    public boolean isBalanced(TreeNode root) {

        if(root == null){
            return true;
        }

        boolean res = false;


        res = isBalanced(root.left);

        if(res){
            res = isBalanced(root.right);
        }

        if(res){
            res =  Math.abs(countHigh(root.left) - countHigh(root.right)) <= 1;

        }

        return res;


    }

    private int countHigh(TreeNode root) {

       if(root == null){
           return 0;
       }

       return Math.max(countHigh(root.left),countHigh(root.right))+1;


    }

}
