package com.example.leetcode2;

import com.example.letcodeeasy.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yingru.ljw
 * @date 2020-02-13 10:48
 */
public class 填充每个节点的下一个右侧节点指针 {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        Node res = new 填充每个节点的下一个右侧节点指针().connect(n1);

        System.out.println(res);

    }


    public Node connect(Node root) {

        if(root == null){
            return null;
        }

        Queue<Node> queue1 = new LinkedBlockingQueue<>();

        queue1.add(root);

        while (!queue1.isEmpty()){
            int size = queue1.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue1.poll();
                if(i < size-1){
                    cur.next = queue1.peek();
                }
                if(cur.left != null){
                    queue1.add(cur.left);
                }
                if(cur.right != null){
                    queue1.add(cur.right);
                }
            }
        }
        return root;

    }


}

