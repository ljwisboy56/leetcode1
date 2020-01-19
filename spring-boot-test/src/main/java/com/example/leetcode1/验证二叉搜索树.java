package com.example.leetcode1;

import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-01-18 16:45
 */
public class 验证二叉搜索树 {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(15);
        TreeNode rl = new TreeNode(6);
        TreeNode rr = new TreeNode(20);
        root.left = left;
        root.right = right;

        right.left = rl;
        right.right = rr;

        boolean res = new 验证二叉搜索树().isValidBST(root);
        System.out.println(res);


    }

    List<Integer> list = new ArrayList<>();


    public boolean isValidBST(TreeNode root) {

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
