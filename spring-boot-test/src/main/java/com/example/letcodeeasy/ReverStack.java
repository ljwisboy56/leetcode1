package com.example.letcodeeasy;

import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2019-11-25 01:40
 */
public class ReverStack {


    public ListNode ReverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while(head!=null){
            stack.push(head);
            head = head.next;
        }
        if(!stack.isEmpty())
            head = stack.pop();
        ListNode cur = head;
        while(!stack.isEmpty()){
            ListNode node = stack.pop();
            node.next = null;
            cur.next = node;
            cur = node;
        }
        return head;


    }
}
