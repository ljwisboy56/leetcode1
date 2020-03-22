package com.example.leetcode2.copy2;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2020-03-23 00:04
 */
public class 第110平衡二叉树 {

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        boolean res = Math.abs(countHeight(root.left) - countHeight(root.right)) <=1;
        if(res){
            res = isBalanced(root.left);
        }
        if(res){
            res = isBalanced(root.right);
        }
        return res;
    }

    private int countHeight(TreeNode cur){
        return cur == null ? 0 : Math.max(countHeight(cur.left),countHeight(cur.right))+1;
    }

}
