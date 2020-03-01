package com.example.leetcode3;

import com.example.letcodeeasy.TreeNode;

import java.util.*;

/**
 * @author yingru.ljw
 * @date 2020-03-01 14:23
 */
public class 最接近的二叉搜索树值2 {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);

        t3.left = t2;
        t3.right = t4;
        t2.left = t1;
        List<Integer> list = new 最接近的二叉搜索树值2().closestKValues(t3,2.0000000,3);
        System.out.println(list);



    }

    List<Integer> list = new ArrayList<>();

    public List<Integer> closestKValues(TreeNode root, double target, int k) {

        midOrder(root);

        Map<Double,HashSet<Integer>> map = new TreeMap<>();

        for (int i = 0; i < list.size(); i++) {
            if(map.get(Math.abs(list.get(i)-target)) == null){
                HashSet<Integer> set = new HashSet<>();
                set.add(list.get(i));
                map.put(Math.abs(list.get(i)-target),set);
            }else {
                HashSet<Integer> set = map.get(Math.abs(list.get(i)-target));
                set.add(list.get(i));
                map.put(Math.abs(list.get(i)-target),set);
            }
        }

        List<Integer> res = new ArrayList<>();
        int index = 0;

        for(Map.Entry<Double,HashSet<Integer>> setEntry : map.entrySet()){
            if(index == k){
                break;
            }
            HashSet<Integer> set = setEntry.getValue();
            res.addAll(set);
            index = index + set.size();
        }
        return res;
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
