package com.example.leetcode2.copy1;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author yingru.ljw
 * @date 2020-02-20 10:59
 */
public class 填充每个节点的下一个右侧节点指针 {

    public static void main(String[] args) {

        Node l1 = new Node(1);
        Node l2 = new Node(2);
        Node l3 = new Node(3);
        Node l4 = new Node(4);
        Node l5 = new Node(5);

        l1.left = l2;
        l1.right = l3;
        l2.left = l4;
        l2.right = l5;

        Node res = new 填充每个节点的下一个右侧节点指针().connect(l1);
        System.out.println(res);

    }

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

        return copy.next;

    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

}
