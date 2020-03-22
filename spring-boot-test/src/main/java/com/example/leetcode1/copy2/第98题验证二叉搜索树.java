package com.example.leetcode1.copy2;

import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-22 19:40
 */
public class 第98题验证二叉搜索树 {


    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        if (!helper(node.right, val, upper)) {
            return false;
        }
        if (!helper(node.left, lower, val)) {
            return false;
        }
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
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
