package com.example.leetcode1;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2020-01-18 17:35
 */
public class 相同的树 {



    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q != null){
            return false;
        }

        if(q == null && p !=null){
            return false;
        }

        if(q == null && p == null){
            return true;
        }

        boolean res =false;

        if(p.val == q.val){
            res = true;
        }

        if(res){
            res = isSameTree(p.left,q.left);
        }

        if(res){
            res = isSameTree(p.right,q.right);
        }
        return res;

    }

}
