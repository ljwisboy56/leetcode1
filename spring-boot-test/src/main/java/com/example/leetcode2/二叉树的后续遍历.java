package com.example.leetcode2;

import com.example.letcodeeasy.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-16 15:35
 */
public class 二叉树的后续遍历 {


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
