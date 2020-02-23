package com.example.leetcode2.copyleetcode2;

import com.example.letcodeeasy.Node;

/**
 * @author yingru.ljw
 * @date 2020-02-21 21:21
 */
public class 复制带随机指针的链表 {

    public Node copyRandomList(Node head) {

        if(head == null){
            return null;
        }

        Node copy = head;

        //复制链表放到下一个节点
        while (head != null){

            Node next = head.next;

            Node clone = new Node(head.val);

            head.next = clone;

            clone.next = next;

            head = next;

        }

        head = copy;

        while (head != null && head.next != null){
            Node random = head.random;
            Node clone = head.next;
            if(random != null){
                clone.random = random.next;
            }
            head = head.next.next;
        }

        head = copy;

        Node dummy = new Node(-1);
        Node copyDummy = dummy;

        while (head != null && head.next != null){
            dummy.next = head.next;
            dummy = dummy.next;
            head = head.next.next;
        }

        return copyDummy.next;

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
