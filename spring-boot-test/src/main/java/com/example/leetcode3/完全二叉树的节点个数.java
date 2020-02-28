package com.example.leetcode3;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2020-02-27 14:57
 */
public class 完全二叉树的节点个数 {

    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        return 1 + countNodes(root.right) + countNodes(root.left);

    }


}
