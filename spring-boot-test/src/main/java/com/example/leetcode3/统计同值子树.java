package com.example.leetcode3;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2020-02-28 20:42
 */
public class 统计同值子树 {

    int count = 0;

    boolean is_uni(TreeNode node) {

        if (node.left == null && node.right == null) {
            count++;
            return true;
        }

        boolean is_unival = true;

        if (node.left != null) {
            is_unival = is_uni(node.left) && is_unival && node.left.val == node.val;
        }

        if (node.right != null) {
            is_unival = is_uni(node.right) && is_unival && node.right.val == node.val;
        }

        if (!is_unival) {
            return false;
        }
        count++;
        return true;
    }
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        is_uni(root);
        return count;
    }


}
