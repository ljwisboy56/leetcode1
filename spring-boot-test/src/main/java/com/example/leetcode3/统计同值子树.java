package com.example.leetcode3;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2020-02-28 20:42
 */
public class 统计同值子树 {

    public int countUnivalSubtrees(TreeNode root) {

        if(root == null){
            return 0;
        }

        int left = countUnivalSubtrees(root.left);

        int right = countUnivalSubtrees(root.right);

        if(left == right){
            return left + right +1;
        }else {
            return left + right;
        }

    }

}
