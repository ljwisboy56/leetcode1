package com.example.leetcode2;

import com.example.letcodeeasy.TreeNode;
import org.apache.poi.hssf.record.formula.functions.T;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-12 22:14
 */
public class 二叉树展开为链表 {

    public static void main(String[] args) {

        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        TreeNode l3 = new TreeNode(3);
        TreeNode l4 = new TreeNode(4);
        TreeNode l5 = new TreeNode(5);
        TreeNode l6 = new TreeNode(6);

        l1.left = l2;
        l1.right = l5;
        l2.left = l3;
        l2.right = l4;
        l5.right = l6;

        new 二叉树展开为链表().flatten(l1);

    }

    public void flatten(TreeNode root) {

        if (root == null){
            return;
        }else {
            //先将右边铺平
            flatten(root.right);
            //再将左边铺平
            flatten(root.left);
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
