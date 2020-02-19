package com.example.leetcode2.copyleetcode2;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2020-02-19 23:03
 */
public class 二叉树展开为链表 {

    TreeNode head = new TreeNode(-1);

    public void flatten(TreeNode root) {

        if(root == null){
            return;
        }

        if(root.left != null){
            flatten(root.left);
        }


    }

}
