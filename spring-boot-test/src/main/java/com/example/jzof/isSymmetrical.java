package com.example.jzof;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2019-12-21 15:48
 */
public class isSymmetrical {

    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null){
            return true;
        }

        return doSymmetrical(pRoot.left,pRoot.right);

    }

    private boolean doSymmetrical(TreeNode left, TreeNode right) {
        if((left == null && right != null)|| (right == null && left !=null)){
            return false;
        }

        if((left == null) && (right == null)){
            return true;
        }

        boolean res = false ;
        if(left.val == right.val){
            res =  true;
        }
        if(res){
            res = doSymmetrical(left.left,right.right);
        }

        if(res){
           res =  doSymmetrical(left.right,right.left);
        }
        return res;

    }
}
