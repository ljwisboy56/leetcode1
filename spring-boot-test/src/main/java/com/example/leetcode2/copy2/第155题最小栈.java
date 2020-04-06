package com.example.leetcode2.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-28 15:19
 */
public class 第155题最小栈 {

    Node head;

    /** initialize your data structure here. */
    public 第155题最小栈() {

    }

    public void push(int x) {
        if(head == null){
            head = new Node(x,x);
        }else {
            Node node = new Node(x,Math.min(x,head.min));
            node.next = head;
            head = node;
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    class Node{

        int min ;
        int val ;
        Node next;

        Node(int val,int min){
            this.val = val;
            this.min = min;
        }

    }

}
