package com.example.leetcode2;

import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-15 02:24
 */
public class 求根到叶子节点数字之和 {



    public static void main(String[] args) {

        TreeNode l1 = new TreeNode(4);
        TreeNode l2 = new TreeNode(9);
        TreeNode l3 = new TreeNode(0);
        TreeNode l4 = new TreeNode(5);
        TreeNode l5 = new TreeNode(1);

        l1.left = l2;
        l1.right = l3;
        l3.left = l4;
        l3.right = l5;


        System.out.println(new 求根到叶子节点数字之和().sumNumbers(l1));

    }

    int res = 0;


    public int sumNumbers(TreeNode root) {

        if(root == null){
            return 0;
        }

        helper(root);

        return res;

    }

    List<Integer> list = new ArrayList<>();

    private void helper(TreeNode root) {
        if(root != null && root.left == null && root.right == null){
            list.add(root.val);
            StringBuilder stringBuilder = new StringBuilder();
            for (Integer tmp : list){
                stringBuilder.append(tmp);
            }
            res += Integer.valueOf(stringBuilder.toString());
        }else {
            list.add(root.val);
            //递归左边
            if(root.left != null){
                helper(root.left);
                list.remove(list.size()-1);
            }
            if(root.right != null){
                helper(root.right);
                list.remove(list.size()-1);
            }
        }

    }


}
