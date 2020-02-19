package com.example.leetcode2;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2020-02-12 20:19
 */
public class 路径总和 {

    int target = 0;


    public boolean hasPathSum(TreeNode root, int sum) {

        if(root == null){
            return false;
        }


        this.target = sum;

        return doFindTarget(root,0);


    }

    private boolean doFindTarget(TreeNode root,int count) {

        if(root != null && root.left == null && root.right == null){
            count += root.val;
            return target == count;
        }else {
            count += root.val;
            if(root.left != null){
                if(doFindTarget(root.left,count)){
                    return true;
                }
            }
            if(root.right != null){
                if(doFindTarget(root.right,count)){
                    return true;
                }
            }
        }
        return false;

    }


}
