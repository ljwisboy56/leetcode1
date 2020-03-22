package com.example.leetcode1.copy2;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2020-03-22 21:00
 */
public class 第100题相同的树 {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null){
            return true;
        }

        if(p != null && q == null){
            return false;
        }

        if(p == null && q != null){
            return false;
        }

        boolean res = p.val == q.val;

        if(res){
            res = isSameTree(p.left,q.left);
        }

        if(res){
            res = isSameTree(p.right,q.right);
        }
        return res;

    }

}
