package com.example.leetcode2;

import com.example.letcodeeasy.TreeNode;

import java.util.Arrays;

/**
 * @author yingru.ljw
 * @date 2020-02-12 17:51
 */
public class 从中序与后序遍历序列构造二叉树 {

    public static void main(String[] args) {
        int[] a1 = new int[]{9,3,15,20,7};
        int[] b1 = new int[]{9,15,7,20,3};

        TreeNode root = new 从中序与后序遍历序列构造二叉树().buildTree(a1,b1);
        System.out.println(root);


    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if(postorder.length == 0||inorder.length == 0){
            return null;
        }
        //找到后续遍历的最后一个节点就是根节点
        TreeNode node = new TreeNode(postorder[postorder.length-1]);
        //在中序遍历中找到这个根节点
        for(int i = 0; i < inorder.length; i++){
            if(postorder[postorder.length-1] == inorder[i]){
                node.left = buildTree(Arrays.copyOfRange(inorder, 0, i),Arrays.copyOfRange(postorder, 0, i));
                node.right = buildTree(Arrays.copyOfRange(inorder, i+1,inorder.length),Arrays.copyOfRange(postorder, i, postorder.length-1));
            }
        }
        return node;

    }

}
