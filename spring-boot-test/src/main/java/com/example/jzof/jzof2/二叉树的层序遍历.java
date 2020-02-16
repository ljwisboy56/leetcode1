package com.example.jzof.jzof2;

import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yingru.ljw
 * @date 2019-12-25 01:11
 */
public class 二叉树的层序遍历 {

    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        if(root == null){
            return list;
        }

        Queue<TreeNode> queue = new LinkedBlockingQueue<>();

        queue.add(root);

        while (!queue.isEmpty()){

            TreeNode node = queue.poll();

            list.add(node.val);

            if(node.left != null){
                queue.add(root.left);
            }
            if(node.right != null){
                queue.add(root.right);
            }
        }
        return list;

    }

}
