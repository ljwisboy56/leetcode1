package com.example.leetcode2.copy2;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2020-03-28 15:35
 */
public class 第156题上下翻转二叉树 {

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }

        TreeNode LE = root.left;
        TreeNode RI = root.right;
        TreeNode res = upsideDownBinaryTree(root.left);
        root.left = null;
        root.right = null;
        LE.right = root;
        LE.left = RI;
        return res;
    }

}
