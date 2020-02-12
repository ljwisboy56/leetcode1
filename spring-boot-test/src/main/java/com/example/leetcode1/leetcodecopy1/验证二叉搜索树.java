package com.example.leetcode1.leetcodecopy1;

import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-11 22:59
 */
public class 验证二叉搜索树 {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t3 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        t5.left = t1;
        t5.right = t4;
        t4.left = t3;
        t4.right = t6;

    }


    List<Integer> list = new ArrayList<>();

    public boolean isValidBST2(TreeNode root) {

        mid(root);

        for (int i = 0; i < list.size()-1;i++){
            if(list.get(i) >= list.get(i+1)){
                return false;
            }

        }
        return true;


    }

    private void mid(TreeNode root) {

        if(root == null){
            return;
        }

        if(null != root.left){
            mid(root.left);
        }
        list.add(root.val);

        if(root.right != null){
            mid(root.right);
        }
    }


}
