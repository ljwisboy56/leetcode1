package com.example.leetcode1;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-01-12 23:26
 */
public class 删除链表中的重复元素 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
//        ListNode l3 = new ListNode(2);
//        ListNode l4 = new ListNode(2);
//        ListNode l5 = new ListNode(5);
//        ListNode l6 = new ListNode(5);
//        ListNode l7 = new ListNode(6);

        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
//        l5.next = l6;
//        l6.next = l7;

        ListNode res = new 删除链表中的重复元素().deleteDuplicates(l1);
        System.out.println(res);



    }

    public ListNode deleteDuplicates(ListNode head) {

        if(head == null){
            return null;
        }

        ListNode dummy = new ListNode(-1);

        ListNode copyDummy = dummy;

        dummy.next = head;

        while (head != null){
            if(head != null && head.next != null && head.val == head.next.val){
                while (head != null && head.next != null  && head.next.val == head.val){
                    head = head.next;
                }
                dummy.next = head;
                dummy = dummy.next;
            }else {
                dummy.next = head;
                dummy = dummy.next;
            }
            head = head.next;
        }
        return copyDummy.next;

    }
}
