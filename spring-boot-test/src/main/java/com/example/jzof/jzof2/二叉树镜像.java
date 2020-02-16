package com.example.jzof.jzof2;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2019-12-24 22:54
 */
public class 二叉树镜像 {

    public void Mirror(TreeNode root) {
        if(root == null){
            return;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right =tmp;

        if(root.left != null){
            Mirror(root.left);
        }

        if(root.right != null){
            Mirror(root.right);
        }

    }

}
