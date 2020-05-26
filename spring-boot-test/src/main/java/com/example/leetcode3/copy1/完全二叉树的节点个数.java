package com.example.leetcode3.copy1;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2020-03-02 23:43
 */
public class 完全二叉树的节点个数 {


    public int countNodes(TreeNode root) {

        if(root == null){
            return 0;
        }

        return countNodes(root.left) + countNodes(root.right) +1;

    }

}
