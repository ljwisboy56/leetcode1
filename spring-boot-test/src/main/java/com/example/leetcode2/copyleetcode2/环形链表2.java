package com.example.leetcode2.copyleetcode2;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-02-22 11:39
 */
public class 环形链表2 {

    public ListNode detectCycle(ListNode head) {

        if(head == null || head.next == null){
            return null;
        }

        ListNode p1 = head.next;

        ListNode p2 = head.next.next;


        ListNode meet = null;

        while (p1 != null && p2 != null){
            if(p1 == p2){
                meet = p1;
                break;
            }else {
                p1 = p1.next;
                if(p2.next != null){
                    p2 = p2.next.next;
                }else {
                    p2 = null;
                }
            }
        }

        if(meet == null){
            return null;
        }

        while (head != meet){
            head =head.next;
            meet = meet.next;
        }

        return null;
    }
}
