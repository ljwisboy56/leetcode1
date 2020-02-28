package com.example.leetcode3;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2020-02-28 12:00
 */
public class 二叉搜索树的最近公共祖先 {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        int pval = p.val;

        int qval = q.val;

        int parent = root.val;

        if(pval > parent && qval > parent){
            return lowestCommonAncestor(root.right,p,q);
        }else if(pval < parent && qval < parent){
            return lowestCommonAncestor(root.left,p,q);
        }else {
            return root;
        }

    }

}
