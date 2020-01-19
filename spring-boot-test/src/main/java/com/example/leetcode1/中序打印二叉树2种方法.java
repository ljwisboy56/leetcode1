package com.example.leetcode1;

import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2020-01-18 15:50
 */
public class 中序打印二叉树2种方法 {


    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        if(root.left != null){
            inorderTraversal(root.left);
        }
        list.add(root.val);
        if(root.right != null){
            inorderTraversal(root.right);
        }

        return list;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()){

            while (root != null){
                stack.push(root);
                root = root.left;
            }

            if(!stack.isEmpty()){
                TreeNode node = stack.pop();
                list.add(node.val);
                root = node.right;
            }
        }
        return list;

    }



}
