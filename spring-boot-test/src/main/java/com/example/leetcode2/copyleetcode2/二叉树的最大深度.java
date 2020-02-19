package com.example.leetcode2.copyleetcode2;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2020-02-19 20:43
 */
public class 二叉树的最大深度 {


    public int maxDepth(TreeNode root) {

        return root == null ? 0 : Math.max(maxDepth(root.left),maxDepth(root.right))+1;

    }


}
