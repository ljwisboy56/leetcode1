package com.example.leetcode2.copy1;

import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2020-02-22 12:11
 */
public class 二叉树的前序遍历 {


    /**
     * 标准的前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if(root == null){
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }

        return res;

    }

    public List<Integer> preorderTraversal2(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if(root == null){
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty() || root != null){
            while (root != null){
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }

            if(!stack.isEmpty()){
                TreeNode cur = stack.pop();
                root = cur.right;
            }
        }

        return res;

    }


}
