package com.example.leetcode2.copyleetcode2;

/**
 * @author yingru.ljw
 * @date 2020-02-22 17:02
 */
public class MinStack {

    public static void main(String[] args) {

        MinStack stack = new MinStack();
        stack.push(1);
        stack.push(-2);
        stack.push(0);
        System.out.println(stack.getMin());

    }

    Node head;

    /** initialize your data structure here. */
    public MinStack() {

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
