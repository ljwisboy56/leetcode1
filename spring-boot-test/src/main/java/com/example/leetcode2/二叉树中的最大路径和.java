package com.example.leetcode2;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2020-02-14 13:51
 */
public class 二叉树中的最大路径和 {

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if(root == null){
            return 0;
        }else {
            //先求出左子树的最大值
            int left = helper(root.left);
            //再求出右子树的最大值
            int right = helper(root.right);
            //记录当前的最大值
            res = Math.max(res,(left+right+root.val));
            //其实就出 max(0,left+root.val,right+root.val)三者谁最大
            return Math.max(0,Math.max(left,right)+root.val);
        }

    }

}
