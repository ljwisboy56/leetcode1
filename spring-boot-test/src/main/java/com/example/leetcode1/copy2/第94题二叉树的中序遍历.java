package com.example.leetcode1.copy2;

import com.example.letcodeeasy.TreeNode;
import sun.jvm.hotspot.debugger.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2020-03-22 17:30
 */
public class 第94题二叉树的中序遍历 {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }

            if (!stack.isEmpty()){
                TreeNode tmp = stack.pop();
                res.add(tmp.val);
                root = tmp.right;
            }
        }
        return res;
    }

}
