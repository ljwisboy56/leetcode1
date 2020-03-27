package com.example.leetcode2.copy2;

import com.example.letcodeeasy.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-26 22:07
 */
public class 第145题二叉树的后序遍历 {

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return output;

    }

}
