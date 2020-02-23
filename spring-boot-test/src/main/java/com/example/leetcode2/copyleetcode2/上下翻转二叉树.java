package com.example.leetcode2.copyleetcode2;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2020-02-22 17:32
 */
public class 上下翻转二叉树 {

    /**
     * 不会做
     * 输入: [1,2,3,4,5]
     *
     *     1
     *    / \
     *   2   3
     *  / \
     * 4   5
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null){
            return null;
        }

        return dfs(null,root);
    }

    private TreeNode dfs(TreeNode parent, TreeNode root) {

        return null;


    }

}
