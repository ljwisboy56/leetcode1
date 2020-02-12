package com.example.leetcode2;

import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yingru.ljw
 * @date 2020-02-12 11:47
 */
public class 二叉树的层次遍历 {

    List<List<Integer>> allList = new ArrayList<>();

    /**
     * 用队列
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null){
            return allList;
        }

        //奇数队列
        Queue<TreeNode> queue1 = new LinkedBlockingQueue<>();

        //偶数队列
        Queue<TreeNode> queue2 = new LinkedBlockingQueue<>();
        //先放入奇数队列
        queue1.add(root);

        while (!queue1.isEmpty() || !queue2.isEmpty()){
            List<Integer> list = new ArrayList<>();
            //如果奇数队列不等于空
            if(!queue1.isEmpty()){
                while (!queue1.isEmpty()){
                    TreeNode curNode = queue1.poll();

                    //放入队列2
                    list.add(curNode.val);

                    //放入偶数队列
                    if(curNode.left != null){
                        queue2.add(curNode.left);
                    }
                    if(curNode.right != null){
                        queue2.add(curNode.right);
                    }
                }
            }else {
                while (!queue2.isEmpty()){
                    TreeNode curNode = queue2.poll();

                    //放入队列2
                    list.add(curNode.val);

                    if(curNode.left != null){
                        queue1.add(curNode.left);
                    }

                    if(curNode.right != null){
                        queue1.add(curNode.right);
                    }
                }
            }
            allList.add(list);
        }

        return allList;
    }

}
