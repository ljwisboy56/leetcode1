package com.example.letcodeeasy;

import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2019-11-25 00:56
 */
public class FindKthToTail {

    public ListNode FindKthToTail(ListNode head,int k) {

        Stack<ListNode> stack = new Stack<>();

        if(head == null){
            return null;
        }

        //首先把所有节点压入栈中
        while (head != null){
            stack.add(head);
            head = head.next;
        }

        ListNode listNode = null;
        int i = 1;
        //当数组不等于空的时候遍历出来即可
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
