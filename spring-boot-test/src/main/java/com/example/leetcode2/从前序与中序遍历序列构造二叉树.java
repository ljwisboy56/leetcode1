package com.example.leetcode2;

import com.example.letcodeeasy.TreeNode;

import java.util.Arrays;

/**
 * @author yingru.ljw
 * @date 2020-02-12 12:29
 */
public class 从前序与中序遍历序列构造二叉树 {


    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length == 0||inorder.length == 0){
            return null;
        }
        TreeNode node = new TreeNode(preorder[0]);
        for(int i = 0; i < inorder.length; i++){
            if(preorder[0] == inorder[i]){
                node.left = buildTree(Arrays.copyOfRange(preorder, 1, i+1), Arrays.copyOfRange(inorder, 0, i));
                node.right = buildTree(Arrays.copyOfRange(preorder, i+1, preorder.length), Arrays.copyOfRange(inorder, i+1,inorder.length));
            }
        }
        return node;

    }

}
