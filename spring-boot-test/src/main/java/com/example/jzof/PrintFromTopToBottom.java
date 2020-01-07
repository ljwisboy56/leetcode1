package com.example.jzof;

import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author yingru.ljw
 * @date 2019-12-01 16:05
 */
public class PrintFromTopToBottom {


    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {



        ArrayList<Integer> list = new ArrayList<>();

        if(root == null){
            return list;
        }

        Queue<TreeNode> queue = new LinkedBlockingDeque<>();

        queue.add(root);

        while (!queue.isEmpty()){

            TreeNode curNode = queue.poll();

            list.add(curNode.val);

            if(curNode.left != null){
                queue.add(curNode.left);
            }
            if(curNode.right != null){
                queue.add(curNode.right);
            }

        }

        return list;

    }


}
