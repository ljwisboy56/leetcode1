package com.example.jzof2;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2019-12-29 16:25
 */
public class 平衡二叉树 {

    public boolean IsBalanced_Solution(TreeNode root) {

        if(root == null){
            return true;
        }

        boolean res = false;

        if(Math.abs(maxDepth(root.left) - maxDepth(root.right)) <=1){
            res = true;
        }

        if(res){
           res =  IsBalanced_Solution(root.left);
        }

        if(res){
            res = IsBalanced_Solution(root.right);
        }

        return res;

    }

    private int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
