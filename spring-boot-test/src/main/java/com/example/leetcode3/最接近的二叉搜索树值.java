package com.example.leetcode3;

import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-29 22:50
 */
public class 最接近的二叉搜索树值 {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        int min = Integer.MAX_VALUE;

        int index = 0;

        for (int i = 0; i < list.size(); i++) {
            if(Math.abs(list.get(i) - 3.7142) < min){
                index = i;
            }
        }
        System.out.println(index);

    }

    List<Integer> list = new ArrayList<>();

    public int closestValue(TreeNode root, double target) {

        midOrder(root);

        double min = Double.MAX_VALUE;

        int index = 0;

        for (int i = 0; i < list.size(); i++) {
            if(Math.abs(list.get(i) - target) < min){
                min = Math.abs(list.get(i) - target);
                index = i;
            }
        }
        return list.get(index);

    }

    private void midOrder(TreeNode root) {

        if(root == null){
            return;
        }

        if(root.left != null){
            midOrder(root.left);
        }

        list.add(root.val);

        if(root.right != null){
            midOrder(root.right);
        }

    }

}
