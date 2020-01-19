package com.example.leetcode1;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-01-13 23:11
 */
public class 分隔链表 {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode res = new 分隔链表().partition(l1,4);
        System.out.println(res);

    }


    public ListNode partition(ListNode head, int x) {

        if(head == null){
            return null;
        }


        ListNode afterHead = new ListNode(-1);
        ListNode beforeHead = new ListNode(-1);

        ListNode copyBeforeHead = beforeHead;
        ListNode copyAfterHead = afterHead;

        while (head != null){
            if(head.val < x){
                beforeHead.next = new ListNode(head.val);
                beforeHead = beforeHead.next;
            }else {
                afterHead.next = new ListNode(head.val);
                afterHead = afterHead.next;
            }
            head = head.next;
        }

        ListNode tmp = copyBeforeHead;
        while (copyBeforeHead.next != null){
            copyBeforeHead = copyBeforeHead.next;
        }

        copyBeforeHead.next = copyAfterHead.next;

        return tmp.next;

    }

}
