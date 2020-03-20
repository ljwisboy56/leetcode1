package com.example.leetcode1.copy2;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-03-03 19:11
 */
public class 两数相加 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next= l2;
        l2.next = l3;

        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;

        ListNode res = new 两数相加().addTwoNumbers(l1,l4);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        StringBuilder stringBuilder = new StringBuilder();
        while (l1 != null){
            stringBuilder.append(l1.val);
            l1 = l1.next;
        }

        int res1 = Integer.valueOf(stringBuilder.reverse().toString());

        stringBuilder = new StringBuilder();
        while (l2 != null){
            stringBuilder.append(l2.val);
            l2 = l2.next;
        }

        int res2 = Integer.valueOf(stringBuilder.reverse().toString());

        int res = res1 + res2;

        int len = (res +"").length();

        String[] chars = String.valueOf(res).split("");

        ListNode dummy = new ListNode(-1);
        ListNode copy = dummy;

        for (int i = len-1; i >= 0; i--) {
            dummy.next = new ListNode(Integer.valueOf(chars[i]));
            dummy = dummy.next;
        }

        return copy.next;
    }


}
