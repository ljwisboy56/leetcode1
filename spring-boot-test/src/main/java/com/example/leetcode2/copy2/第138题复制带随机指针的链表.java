package com.example.leetcode2.copy2;


import java.util.HashMap;

/**
 * @author yingru.ljw
 * @date 2020-03-26 01:47
 */
public class 第138题复制带随机指针的链表 {

    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        //复制一份头结点
        Node copy = head;

        //先复制一遍节点
        while (head != null){
            Node tmp = new Node(head.val);
            Node next = head.next;
            head.next = tmp;
            tmp.next = next;
            if(next == null){
                break;
            }
            head = head.next.next;
        }

        head = copy;

        //复制随机节点
        while (head != null){
            head.next.random = head.random == null ?null:head.random.next;
            head = head.next.next;
        }

        head = copy;

        Node dummy = new Node(-1);
        dummy.next = head.next;
        while (head != null && head.next != null) {
            Node clone = head.next;
            head.next = clone.next;
            clone.next = clone.next == null ? null : clone.next.next;
            head = head.next;
        }
        return dummy.next;


    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }



}
