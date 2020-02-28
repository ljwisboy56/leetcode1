package com.example.leetcode3;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-02-26 14:07
 */
public class 反转链表 {

    public ListNode reverseList(ListNode head) {

        if(head == null){
            return null;
        }

        ListNode pre = null;
        ListNode next = null;

        while (head != null){

            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;

    }
}
