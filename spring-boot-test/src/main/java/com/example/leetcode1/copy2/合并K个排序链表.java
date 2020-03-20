package com.example.leetcode1.copy2;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-03-05 00:49
 */
public class 合并K个排序链表 {

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0){
            return null;
        }

        ListNode head = null;
        for (ListNode list : lists) {
            head = mergeTwoLists(head, list);
        }
        return head;

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 != null){
            return l2;
        }
        if(l2 == null && l1 != null){
            return l1;
        }

        ListNode head = new ListNode(-1);
        ListNode copy = head;

        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                head.next = new ListNode(l1.val);
                head = head.next;
                l1 = l1.next;
            }else {
                head.next = new ListNode(l2.val);
                head = head.next;
                l2 = l2.next;
            }
        }

        if(l1 != null){
            head.next = l1;
        }

        if(l2 != null){
            head.next = l2;
        }

        return copy.next;
    }

}
