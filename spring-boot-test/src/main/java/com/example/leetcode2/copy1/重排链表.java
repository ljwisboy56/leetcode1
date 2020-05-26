package com.example.leetcode2.copy1;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-02-22 11:46
 */
public class 重排链表 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        new 重排链表().reorderList(l1);

        System.out.println(l1);


    }


    public void reorderList(ListNode head) {

        if(head == null){
            return;
        }

        ListNode copy = head;

        while (head != null){
            ListNode reverseNode = reverse(head.next);
            head.next = reverseNode;
            head  = head.next;
        }

        head = copy;

    }

    private ListNode reverse(ListNode head){

        ListNode pre =null;
        ListNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
