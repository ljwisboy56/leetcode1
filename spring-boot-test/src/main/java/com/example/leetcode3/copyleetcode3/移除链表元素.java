package com.example.leetcode3.copyleetcode3;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-03-02 15:21
 */
public class 移除链表元素 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode res = new 移除链表元素().removeElements(l1,2);
        System.out.println(res);

    }


    public ListNode removeElements(ListNode head, int val) {

        if(head == null){
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        while (head != null){
            if(head.val == val){
                pre.next = head.next;
                head = head.next;
            }else {
                pre = pre.next;
                head = head.next;
            }
        }
        return dummy.next;

    }

}
