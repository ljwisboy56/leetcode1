package com.example.leetcode2.copyleetcode2;

import com.example.letcodeeasy.ListNode;
import sun.jvm.hotspot.debugger.Page;

/**
 * @author yingru.ljw
 * @date 2020-02-22 11:29
 */
public class 环形链表 {

    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }

        if(head.next == null){
            return false;

        }

        ListNode p1 = head.next;

        ListNode p2 = head.next.next;

        while (p1 != null && p2 != null){
            if(p1 == p2){
                return true;
            }else {
                p1 = p1.next;
                if(p2.next != null){
                    p2 = p2.next.next;
                }else {
                    p2 = null;
                }
            }
        }


        return false;

    }
}
