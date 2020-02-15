package com.example.leetcode2;

import com.example.letcodeeasy.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yingru.ljw
 * @date 2020-02-13 11:57
 */
public class 填充每个节点的下一个右侧节点指针2 {



    public Node connect(Node root) {

        if(root == null){
            return null;
        }

        Queue<Node> queue1 = new LinkedBlockingQueue<>();

        Queue<Node> queue2 = new LinkedBlockingQueue<>();

        queue1.add(root);

        while (!queue1.isEmpty() || !queue2.isEmpty()){
            List<Node> list = new ArrayList<>();
            if(!queue1.isEmpty()){
                while (!queue1.isEmpty()){
                    Node cur = queue1.poll();
                    list.add(cur);
                    if(cur.left != null){
                        queue2.add(cur.left);
                    }
                    if(cur.right != null){
                        queue2.add(cur.right);
                    }
                }
            }else {
                while (!queue2.isEmpty()){
                    Node cur = queue2.poll();
                    list.add(cur);
                    if(cur.left != null){
                        queue1.add(cur.left);
                    }
                    if(cur.right != null){
                        queue1.add(cur.right);
                    }
                }
            }

            Node cur = list.get(0);
            for (int i =1; i < list.size();i++){
                cur.next = list.get(i);
                cur = cur.next;
            }
        }
        return root;

    }

}
