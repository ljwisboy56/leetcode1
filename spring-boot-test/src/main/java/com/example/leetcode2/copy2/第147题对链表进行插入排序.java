package com.example.leetcode2.copy2;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-03-27 01:08
 */
public class 第147题对链表进行插入排序 {


    public ListNode insertionSortList(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null){
            ListNode next = cur.next;
            if(next != null && next.val < cur.val){
                //在有序队列里面找，找到他应该放置的位置（也就是比pre大的那个）
                while (pre.next != null && pre.next.val < next.val){
                    pre = pre.next;
                }
                ListNode tmp = pre.next;
                pre.next = next;
                cur.next= next.next;
                next.next = tmp;
                pre = dummy;
            }else {
                cur = cur.next;
            }
        }
        return dummy.next;

    }

}
