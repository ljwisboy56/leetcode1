package com.example.leetcode1.copy1;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-02-02 15:48
 */
public class 合并k个排序链表 {


    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0){
            return null;
        }

        ListNode head = lists[0];
        for(int i = 1;i < lists.length;i++){
            head = mergeTwoLists(head,lists[i]);
        }
        return head;

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(-1);
        ListNode copy = res;

        while (l1 != null && l2 != null){

            if(l1 != null && l2 != null && l1.val <= l2.val){
                res.next = new ListNode(l1.val);
                res = res.next;
                l1 = l1.next;
            }
            else {
                res.next = new ListNode(l2.val);
                res = res.next;
                l2 = l2.next;
            }
        }

        while (l1 != null){
            res.next = new ListNode(l1.val);
            res = res.next;
            l1 = l1.next;
        }

        while (l2 != null){
            res.next = new ListNode(l2.val);
            res = res.next;
            l2 = l2.next;
        }

        return copy.next;


    }

}
