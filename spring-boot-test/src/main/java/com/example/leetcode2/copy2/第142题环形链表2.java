package com.example.leetcode2.copy2;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-03-26 21:18
 */
public class 第142题环形链表2 {

    public ListNode detectCycle(ListNode head) {

        if(head == null || head.next == null){
            return null;
        }

        ListNode p1 = head.next;
        ListNode p2 = head.next.next;

        while (p1 != null && p2 != null && p2.next != null){
            if(p1 == p2){
                break;
            }else {
                p1 = p1.next;
                p2 = p2.next.next;
            }
        }

        if(p1 == null || p2 == null || p2.next == null){
            return null;
        }

        p1 = head;
        while (p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }


}
