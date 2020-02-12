package com.example.leetcode1.leetcodecopy1;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2020-02-12 00:04
 */
public class 相同的树 {


    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null){
            return true;
        }

        if(p == null || q == null){
            return false;
        }

        boolean res = false;

        res = p.val == q.val;

        if(res){
            res = isSameTree(p.left,q.left);
        }


        if(res){
            res = isSameTree(p.right,q.right);
        }

        return res;


    }

}
