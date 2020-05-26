package com.example.leetcode2.copy1;

import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-19 20:35
 */
public class 二叉树的锯齿形层次遍历 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if(root == null){
            return res;
        }

        LinkedList<TreeNode> queue1 = new LinkedList<>();

        LinkedList<TreeNode> queue2 = new LinkedList<>();

        queue1.add(root);

        int count = 0;

        while (!queue1.isEmpty() || !queue2.isEmpty()){
            List<Integer> list = new ArrayList<>();
            if(!queue1.isEmpty()){
                while (!queue1.isEmpty()){
                    TreeNode cur = queue1.poll();
                    list.add(cur.val);
                    if(cur.left != null){
                        queue2.add(cur.left);
                    }
                    if(cur.right != null){
                        queue2.add(cur.right);
                    }
                }
                count++;
            }else {
                while(!queue2.isEmpty()){
                    TreeNode cur = queue2.poll();
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
            if(count % 2 == 0){
                Collections.reverse(list);
                res.add(list);
            }else {
                res.add(list);
            }

        }
        return res;


    }

}
