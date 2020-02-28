package com.example.leetcode3;

import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2020-02-27 23:29
 */
public class 二叉搜索树中第K小的元素 {

    public int kthSmallest(TreeNode root, int k) {

        if(root == null){
            return 0;
        }

        List<Integer> res = midOrder(root);

        System.out.println(res);

        return res.get(k);
    }

    private List<Integer> midOrder(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }

            if(!stack.isEmpty()){
                TreeNode cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }
}
