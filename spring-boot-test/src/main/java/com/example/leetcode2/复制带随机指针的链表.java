package com.example.leetcode2;

import sun.jvm.hotspot.debugger.Page;

/**
 * @author yingru.ljw
 * @date 2020-02-15 18:28
 */
public class 复制带随机指针的链表 {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        n1.random = n3;
        n2.random = n4;

        Node res = new 复制带随机指针的链表().copyRandomList(n1);
        System.out.println(res);



    }


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
            head = head.next.next;
        }
        return dummy.next;
    }


    static class Node {
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
