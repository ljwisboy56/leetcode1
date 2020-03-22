package com.example.leetcode2.copy2;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2020-03-23 00:51
 */
public class 第114题二叉树展开为链表 {


    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        //先存住右边
        TreeNode right = root.right;
        //把右边放平
        flatten(right);
        //把左边节点放平
        TreeNode left = root.left;
        flatten(left);
        //左边置空
        root.left = null;
        //把左边节点接在右边
        root.right = left;
        while (root.right != null){
            root = root.right;
        }
        root.right = right;
    }
}
