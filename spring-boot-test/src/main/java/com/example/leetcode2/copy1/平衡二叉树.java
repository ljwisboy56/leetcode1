package com.example.leetcode2.copy1;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2020-02-19 21:55
 */
public class 平衡二叉树 {

    public boolean isBalanced(TreeNode root) {

        if(root == null){
            return true;
        }

        boolean res = isBalanced(root.left);

        if(res){
            res = isBalanced(root.right);
        }

        if(res){
            return Math.abs(treeHead(root.left)-treeHead(root.right))<=1;
        }

        return res;

    }

    private int treeHead(TreeNode root){
       return root == null ? 0 : Math.max(treeHead(root.left),treeHead(root.right))+1;
    }

}
