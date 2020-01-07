package com.example.leetcode1;

import com.example.letcodeeasy.ListNode;
import com.example.order.In;

/**
 * @author yingru.ljw
 * @date 2019-12-30 16:40
 */
public class 两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null && l2 == null){
            return null;
        }

        ListNode l1Reverse = reverseListNoe(l1);

        String l1Str = "";
        int l1Int = 0;
        if(l1Reverse != null){
            while (l1Reverse != null){
                l1Str += String.valueOf(l1Reverse.val);
                l1Reverse = l1Reverse.next;
            }
            l1Int = Integer.valueOf(l1Str);
        }

        ListNode l2Reverse = reverseListNoe(l1);
        String l2Str = "";
        int l2Int = 0;
        if(l2Reverse != null){
            while (l2Reverse != null){
                l2Str += String.valueOf(l2Reverse.val);
                l2Reverse = l2Reverse.next;
            }
            l2Int = Integer.valueOf(l2Str);
        }

        Integer resInt = l1Int + l2Int;

        String resStr = String.valueOf(resInt);
        char[] chars = resStr.toCharArray();


        ListNode resNode = new ListNode(-1);
        ListNode newHead = resNode;

        for (char tmp : chars){
            resNode.next = new ListNode((int) tmp);
            resNode = resNode.next;
        }

        return reverseListNoe(newHead.next);
    }

    private ListNode reverseListNoe(ListNode head) {

        if(head == null){
            return null;
        }

        ListNode pre = null;
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
