package com.example.leetcode2.copy1;

import com.example.letcodeeasy.TreeNode;

import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2020-02-23 15:46
 */
public class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        addTreeNode(root);
    }

    /** @return the next smallest number */
    public int next() {
        if(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            int tmp = cur.val;
            addTreeNode(cur.right);
            return tmp;
        }
        return 0;
    }

    private void addTreeNode(TreeNode root){
        while (root != null){
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
