package com.example.leetcode2.copy2;

import com.example.letcodeeasy.TreeNode;

import java.util.Arrays;

/**
 * @author yingru.ljw
 * @date 2020-03-22 23:07
 */
public class 第105题从前序与中序遍历序列构造二叉树 {

    /**
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0||inorder.length == 0){
            return null;
        }

        //这一定是第一个节点
        TreeNode root = new TreeNode(preorder[0]);

        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == root.val){
                index = i;
                break;
            }
        }

        root.left = buildTree(Arrays.copyOfRange(preorder, 1, index+1), Arrays.copyOfRange(inorder, 0, index));
        root.right = buildTree(Arrays.copyOfRange(preorder, index+1, preorder.length), Arrays.copyOfRange(inorder, index+1,inorder.length));

        return root;

    }

}
