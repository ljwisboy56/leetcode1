package com.example.leetcode2;

/**
 * @author yingru.ljw
 * @date 2020-02-17 12:07
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(-2);
        minStack.push(3);

        System.out.println(minStack);

        minStack.pop();

        System.out.println(minStack);

    }

    private Node head;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {

        if(head != null){
            head = new Node(x,Math.min(x,head.min),head);
        }else {
            head = new Node(x,x);
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

    private class Node{
        int val;
        int min;
        Node next;

        Node(int val, int min){
            this.val = val;
            this.min = min;
        }

        public Node(int val,int min,Node next){
            this(val,min);
            this.next = next;
        }
    }

}
