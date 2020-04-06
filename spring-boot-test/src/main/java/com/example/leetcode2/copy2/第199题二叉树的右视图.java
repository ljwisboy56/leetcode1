package com.example.leetcode2.copy2;

import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yingru.ljw
 * @date 2020-03-29 23:26
 */
public class 第199题二叉树的右视图 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()){
            LinkedList<Integer> list = new LinkedList<>();
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
            res.add(list.pollLast());
        }
        return res;
    }
}
