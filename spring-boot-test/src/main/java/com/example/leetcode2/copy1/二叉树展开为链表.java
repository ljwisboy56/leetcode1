package com.example.leetcode2.copy1;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2020-02-19 23:03
 */
public class 二叉树展开为链表 {

    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }else {
            flatten(root.left);
            flatten(root.right);

            TreeNode tmp = root.right;
            root.right = root.left;
            root.left = null;
            while (root.right != null){
                root = root.right;
            }
            root.right = tmp;
        }
    }


}
