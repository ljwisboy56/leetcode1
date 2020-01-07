package com.example.leetcode1;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-01-01 23:55
 */
public class 合并两个有序链表 {


    public static void main(String[] args) {

        ListNode l1 = new ListNode(-9);
        ListNode l2 = new ListNode(3);
        l1.next = l2;

        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(7);
        l3.next = l4;

        ListNode res = new 合并两个有序链表().mergeTwoLists(l1,l3);
        System.out.println(res);

    }

    /**
     *
     * [1,2,4]
     * [1,3,4]
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null && l2 == null){
            return null;
        }

        ListNode head = new ListNode(-1);

        ListNode copyHead = head;

        while (l1 != null && l2 != null){
            if(l1 != null){
                if(l1.val <= l2.val){
                    head.next = new ListNode(l1.val);
                    l1 = l1.next;
                    head = head.next;

                }
            }
            if(l2 != null && l1 != null){
                if(l1.val >= l2.val){
                    head.next = new ListNode(l2.val);
                    l2 = l2.next;
                    head = head.next;

                }
            }
        }

        while (l1 != null){
            head.next = new ListNode(l1.val);
            l1 = l1.next;
            head = head.next;
        }

        while (l2 != null){
            head.next = new ListNode(l2.val);
            l2 = l2.next;
            head = head.next;
        }
        return copyHead.next;

    }

}
