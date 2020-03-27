package com.example.leetcode2.copy2;

import com.example.letcodeeasy.TreeNode;

import java.util.*;

/**
 * @author yingru.ljw
 * @date 2020-03-26 21:56
 */
public class 第144题二叉树的前序遍历 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){

            while (root != null){
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }

            if(!stack.isEmpty()){
                TreeNode cur = stack.pop();
                root = cur.right;
            }
        }

        return list;
    }

}
