package com.example.leetcode3;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2020-02-28 12:42
 */
public class 二叉树的最近公共祖先 {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null || p == root || q == root){
            return root;
        }

        TreeNode leftroot = lowestCommonAncestor(root.left,p,q);
        TreeNode rightroot = lowestCommonAncestor(root.right,p,q);

        if(leftroot == null){
            return rightroot;
        }

        if(rightroot == null){
            return leftroot;
        }

        return root;

    }

}
