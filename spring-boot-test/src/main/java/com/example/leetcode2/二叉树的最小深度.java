package com.example.leetcode2;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2020-02-12 20:07
 */
public class 二叉树的最小深度 {


    public int minDepth(TreeNode root) {

        if(root == null){
            return 0;
        }

        if(root.left == null){
            return minDepth(root.right)+1;
        }

        if(root.right == null){
            return minDepth(root.left)+1;
        }

        return Math.min(minDepth(root.left),minDepth(root.right))+1;

    }

}
