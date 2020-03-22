package com.example.leetcode2.copy2;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2020-03-23 00:32
 */
public class 第112题路径总和 {

    int count = 0;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        return dfs(root,sum);
    }

    private boolean dfs(TreeNode root,int sum) {
        if(root != null && root.left == null && root.right == null){
            count += root.val;
            if(count == sum){
                return true;
            }
            count -= root.val;
        }else {
            if(root.left != null){
                count += root.val;
                if(dfs(root.left,sum)){
                    return true;
                }
                count -= root.val;
            }
            if(root.right != null){
                count += root.val;
                if(dfs(root.right,sum)){
                    return true;
                }
                count -= root.val;
            }
        }
        return false;
    }

}
