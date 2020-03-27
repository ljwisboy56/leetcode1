package com.example.leetcode2.copy2;

import com.example.letcodeeasy.Node;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author yingru.ljw
 * @date 2020-03-23 11:29
 */
public class 第116题填充每个节点的下一个右侧节点指针 {


    public Node connect(Node root) {

        if(root == null){
            return null;
        }

        Node dummy = new Node(-1);
        Node copy = dummy;

        LinkedList<Node> linkedList1 = new LinkedList<>();
        LinkedList<Node> linkedList2 = new LinkedList<>();
        linkedList1.add(root);
        while (!linkedList1.isEmpty() || !linkedList2.isEmpty()){
            ArrayList<Node> list = new ArrayList<>();
            if(!linkedList1.isEmpty()){
                while (!linkedList1.isEmpty()){
                    Node cur = linkedList1.poll();
                    list.add(cur);
                    if(cur.left != null){
                        linkedList2.add(cur.left);
                    }
                    if(cur.right != null){
                        linkedList2.add(cur.right);
                    }
                }
            }else {
                while (!linkedList2.isEmpty()){
                    Node cur = linkedList2.poll();
                    list.add(cur);
                    if(cur.left != null){
                        linkedList1.add(cur.left);
                    }
                    if(cur.right != null){
                        linkedList1.add(cur.right);
                    }
                }
            }

            Node head = list.get(0);
            for (int i = 1; i < list.size() ; i++) {
                head.next = list.get(i);
                head = head.next;
            }
        }

        return root;
    }

}
