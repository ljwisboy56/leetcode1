package com.example.leetcode2;

import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yingru.ljw
 * @date 2020-02-19 01:31
 */
public class 二叉树的右视图 {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        if(root == null){
            return list;
        }

        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();

        queue1.add(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            if (!queue1.isEmpty()) {
                while (!queue1.isEmpty()) {
                    TreeNode cur = queue1.poll();
                    tmp.add(cur.val);
                    if (cur.left != null) {
                        queue2.add(cur.left);
                    }
                    if (cur.right != null) {
                        queue2.add(cur.right);
                    }
                }
            } else {
                while (!queue2.isEmpty()) {
                    TreeNode cur = queue2.poll();
                    tmp.add(cur.val);
                    if (cur.left != null) {
                        queue1.add(cur.left);
                    }
                    if (cur.right != null) {
                        queue1.add(cur.right);
                    }
                }
            }
            list.add(tmp.pollLast());
        }
        return list;
    }

}
