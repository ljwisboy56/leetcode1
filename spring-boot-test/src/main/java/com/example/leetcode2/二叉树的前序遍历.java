package com.example.leetcode2;

import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yingru.ljw
 * @date 2020-02-16 15:00
 */
public class 二叉树的前序遍历 {

    List<Integer> res = new ArrayList<>();

    /**
     * DFS就是
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal3(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        stack.push(current);
        while (!stack.isEmpty()) {
            current = stack.pop();
            list.add(current.val);
            if (current.right != null){
                stack.push(current.right);
            }
            if (current.left != null){
                stack.push(current.left);
            }
        }
        return list;
    }


    public List<Integer> preorderTraversal(TreeNode root) {

        if(root == null){
            return res;
        }

        res.add(root.val);

        if(root.left != null){
            preorderTraversal(root.left);
        }

        if(root.right != null){
            preorderTraversal(root.right);
        }

        return res;

    }

    public List<Integer> preorderTraversal2(TreeNode root) {

        if(root == null){
            return res;
        }

        Stack<TreeNode> queue = new Stack<>();

        while (!queue.isEmpty() || root != null){
            //先把所有的左节点都入队
            while (root != null){
                res.add(root.val);
                queue.push(root);
                root = root.left;
            }

            if (!queue.isEmpty()){
                TreeNode cur = queue.pop();
                if(cur.right != null){
                    root = cur.right;
                }
            }
        }

        return res;
    }


}
