package com.example.leetcode2.copy1;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2020-02-19 22:14
 */
public class 路径总和 {

    int sum = 0;

    public boolean hasPathSum(TreeNode root, int sum) {

        if(root == null){
            return false;
        }

        this.sum = sum;

        return dfs(root, 0);

    }

    private boolean dfs(TreeNode root, int count) {

        if(root == null){
            return false;
        }
        else if(root.left == null && root.right == null){
            count += root.val;
            return count == sum;
        }else {
            count += root.val;
            return dfs(root.left, count) || dfs(root.right, count);
        }
    }

}
