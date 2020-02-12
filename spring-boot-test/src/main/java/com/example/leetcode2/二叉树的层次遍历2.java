package com.example.leetcode2;

import com.example.letcodeeasy.TreeNode;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yingru.ljw
 * @date 2020-02-12 18:08
 */
public class 二叉树的层次遍历2 {

    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        TreeNode l3 = new TreeNode(3);
        TreeNode l4 = new TreeNode(4);
        TreeNode l5 = new TreeNode(5);

        l1.left = l2;
        l1.right = l3;
        l2.left = l4;
        l3.right = l5;


        List<List<Integer>> allList = new 二叉树的层次遍历2().levelOrderBottom(l1);
        System.out.println(allList);
    }

    List<List<Integer>> allList = new ArrayList<>();

    Map<Integer,List<Integer>> map =new HashMap<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if(root == null){
            return allList;
        }

        Queue<TreeNode> queue1 = new LinkedBlockingQueue<>();

        Queue<TreeNode> queue2 = new LinkedBlockingQueue<>();

        int count = 0;

        queue1.add(root);

        while (!queue1.isEmpty() || !queue2.isEmpty()){
            List<Integer> list = new ArrayList<>();
            if(!queue1.isEmpty()){
                while (!queue1.isEmpty()){
                    TreeNode cur =  queue1.poll();
                    list.add(cur.val);
                    if(cur.left != null){
                        queue2.add(cur.left);
                    }
                    if(cur.right != null){
                        queue2.add(cur.right);
                    }
                }
                count++;
            }
            else {
                while (!queue2.isEmpty()){
                    TreeNode cur =  queue2.poll();
                    list.add(cur.val);
                    if(cur.left != null){
                        queue1.add(cur.left);
                    }
                    if(cur.right != null){
                        queue1.add(cur.right);
                    }
                }
                count++;
            }
            map.put(count,list);
        }

        for (int i = map.size();i >=1;i--){
            allList.add(map.get(i));
        }

        return allList;
    }
}
