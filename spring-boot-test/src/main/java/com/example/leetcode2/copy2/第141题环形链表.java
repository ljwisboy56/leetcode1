package com.example.leetcode2.copy2;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-03-26 21:14
 */
public class 第141题环形链表 {

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }

        ListNode p1 = head.next;
        ListNode p2 = head.next.next;

        while (p1 != null && p2 != null && p2.next != null){
            if(p1 == p2){
                return true;
            }else {
                p1 = p1.next;
                p2 = p2.next.next;
            }
        }
        return false;
    }

}
