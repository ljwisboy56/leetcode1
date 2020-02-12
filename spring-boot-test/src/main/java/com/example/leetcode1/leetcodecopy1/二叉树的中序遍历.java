package com.example.leetcode1.leetcodecopy1;

import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2020-02-11 11:21
 */
public class 二叉树的中序遍历 {

    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        doFind(root);

        return list;
    }

    /**
     * 递归
     * @param root
     */
    private void doFind(TreeNode root) {

        if(root == null){
            return;
        }

        if(root.left != null){
            doFind(root.left);
        }
        list.add(root.val);
        if(root.right != null){
            doFind(root.right);
        }

    }

    private void doFindByStack(TreeNode treeNode){

        Stack<TreeNode> stack = new Stack<>();

        while (treeNode != null || !stack.isEmpty()){
            while (treeNode != null){
                stack.push(treeNode.left);
                treeNode = treeNode.left;
            }


            if(!stack.isEmpty()){
                TreeNode node = stack.pop();
                list.add(node.val);
                treeNode = node.right;
            }

        }

    }

}
