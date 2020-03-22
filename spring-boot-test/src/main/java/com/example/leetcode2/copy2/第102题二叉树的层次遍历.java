package com.example.leetcode2.copy2;

import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yingru.ljw
 * @date 2020-03-22 22:52
 */
public class 第102题二叉树的层次遍历 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        //添加第一个节点
        queue1.add(root);

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
            }else {
                while (!queue2.isEmpty()){
                    TreeNode cur = queue2.poll();
                    list.add(cur.val);
                    if(cur.left != null){
                        queue1.add(cur.left);
                    }
                    if(cur.right != null){
                        queue1.add(cur.right);
                    }
                }
            }
            res.add(list);
        }
        return res;
    }

}
