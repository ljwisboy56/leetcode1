package com.example.leetcode2.copyleetcode2;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-02-22 14:16
 */
public class 排序链表 {

    public ListNode sortList(ListNode head) {
        return head == null ? null : doMerge(head);
    }

    private ListNode doMerge(ListNode head){
        if(head.next == null){
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = head;
        ListNode pre = null;

        while (p2 != null && p2.next != null){
            pre = p1;
            p1 = p1.next;
            p2 = p2.next.next;
        }

        pre.next = null;

        ListNode res1 = sortList(head);
        ListNode res2 = sortList(p1);

        return mergeSort(res1,res2);

    }

    private ListNode mergeSort(ListNode p1, ListNode p2) {

        ListNode l1 = p1;

        ListNode l2 = p2;

        ListNode dummy = new ListNode(-1);
        ListNode copy = dummy;

        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                dummy.next = l1;
                l1 = l1.next;
                dummy = dummy.next;
            }else {
                dummy.next = l2;
                l2 = l2.next;
                dummy = dummy.next;
            }
        }

        if(l1 != null){
            dummy.next = l1;
        }

        if(l2 != null){
            dummy.next = l2;
        }

        return copy.next;
    }
}
