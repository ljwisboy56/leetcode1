package com.example.jzof2;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2019-12-24 01:19
 */
public class 树的子结构 {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        if(root1 == null || root2 == null){
            return false;
        }

        boolean res = doJudge(root1,root2);


        if(!res){
            res = HasSubtree(root1.left,root2);
        }

        if(!res){
            res = HasSubtree(root1.right,root2);
        }

        return res;
    }

    private boolean doJudge(TreeNode root1, TreeNode root2) {


        if(root2 == null ){
            return true;
        }

        if(root1 == null ){
            return false;
        }

        boolean res =false;
        if(root1.val == root2.val){
            res = doJudge(root1.left,root2.left);
        }
        if(res){
            res = doJudge(root1.right,root2.right);
        }
        return res;

    }

}
