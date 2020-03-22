package com.example.leetcode2.copy2;
import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2020-03-22 22:45
 */
public class 第101题对称二叉树 {

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return doJudege(root.left,root.right);
    }

    private boolean doJudege(TreeNode left, TreeNode right) {
        if(left == null && right == null){
            return true;
        }
        if(left == null){
            return false;
        }
        if(right == null){
            return false;
        }
        boolean res = left.val == right.val;
        if(res){
            res = doJudege(left.right,right.left);
        }
        if(res){
            res = doJudege(left.left,right.right);
        }
        return res;
    }

}
