package com.example.leetcode1;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-01-16 01:18
 */
public class 翻转链表2 {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        ListNode res = new 翻转链表2().reverseBetween(l1,3,7);
        System.out.println(res);
    }


    public ListNode reverseBetween(ListNode head, int m, int n) {

        if(head == null){
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        if(m == 1){
            return reverseNode(head,n-m+1);
        }

        int count = 0;
        while (head != null){
            if(count == m-2){
                ListNode copy = head;
                ListNode newHead = reverseNode(head.next,n-m+1);
                copy.next = newHead;
                break;

            }
            head = head.next;
            count++;

        }
        return dummy.next;
    }

    private ListNode reverseNode(ListNode head,int len){

        int count = 0;
        ListNode pre = null;
        ListNode next = null;

        while (head != null){
            if(count == len){
                ListNode cur = pre;
                if(pre != null){
                    while (pre.next != null){
                        pre = pre.next;
                    }
                    pre.next = head;
                }
                return cur;
            }
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            count++;
        }

        return pre;
    }

}
