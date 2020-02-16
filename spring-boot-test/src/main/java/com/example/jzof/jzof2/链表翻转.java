package com.example.jzof.jzof2;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2019-12-24 00:58
 */
public class 链表翻转 {


    public ListNode ReverseList(ListNode head) {

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
