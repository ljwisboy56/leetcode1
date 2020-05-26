package com.example.leetcode1.copy1;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-02-10 00:04
 */
public class 删除排序链表中的重复元素 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(3);
//        ListNode l5 = new ListNode(4);
//        ListNode l6 = new ListNode(4);
//        ListNode l7 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
//        l5.next = l6;
//        l6.next = l7;

        ListNode res = new 删除排序链表中的重复元素().deleteDuplicates(l1);
        System.out.println(res);
    }


    public ListNode deleteDuplicates(ListNode head) {

        if(head == null){
            return null;
        }

        ListNode copy = head;

        while (head != null){
            if(head.next != null && head.val == head.next.val){
                ListNode tmp = head;
                while (head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                head = head.next;
                tmp.next = head;
            }else {
                head = head.next;
            }
        }

        return copy;
    }

}
