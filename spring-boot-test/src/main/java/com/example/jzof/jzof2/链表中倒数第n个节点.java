package com.example.jzof.jzof2;

import com.example.letcodeeasy.ListNode;

import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2019-12-24 00:53
 */
public class 链表中倒数第n个节点 {

    public ListNode FindKthToTail(ListNode head,int k) {

        if(head == null){
            return null;
        }

        Stack<ListNode> stack = new Stack<>();


        //首先把所有节点压入栈中
        while (head != null){
            stack.add(head);
            head = head.next;
        }

        ListNode listNode = null;
        int i = 1;
        //然后遍历的从后面找到第k个
        while (!stack.isEmpty()){
            if (i == k){
                listNode = stack.pop();
                break;
            }else {
                stack.pop();
                i++;
            }
        }
        return listNode;
    }
}
