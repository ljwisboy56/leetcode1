package com.example.leetcode1.leetcodecopy1;

import com.example.letcodeeasy.ListNode;

import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-01-18 19:18
 */
public class 两数相加 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(8);
//        ListNode l3 = new ListNode(3);
        l1.next = l2;
//        l2.next =l3;

        ListNode m1 = new ListNode(0);
        ListNode m2 = new ListNode(6);
        ListNode m3 = new ListNode(4);
//        m1.next = m2;
//        m2.next = m3;


        ListNode res = new 两数相加().addTwoNumbers(l1,m1);
        System.out.println(res);


    }



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }

        boolean flag = false;

        ListNode newl1 = l1;
        ListNode newl2 = l2;

        ListNode dummy = new ListNode(-1);
        ListNode copyDummy = dummy;

        while (newl1 != null && newl2 != null){

            int v1 = newl1.val;

            int v2 = newl2.val;

            int value = 0;
            if(flag){
                value = v1 + v2 + 1;
            }else {
                value = v1 + v2;
            }

            //需要进位
            if(value / 10 == 1){
                flag = true;
            }else {
                flag = false;
            }
            value = value % 10;

            dummy.next = new ListNode(value);
            dummy = dummy.next;

            newl1 = newl1.next;
            newl2 = newl2.next;

        }

        while (newl1 != null){
            int tmp = newl1.val;
            int v = 0;
            if(flag){
                v = tmp + 1;
            }else {
                v = tmp;
            }
            //需要进位
            if(v / 10 == 1){
                flag = true;
            }
            v = v % 10;
            dummy.next = new ListNode(v);
            dummy = dummy.next;
            newl1 = newl1.next;
        }

        while (newl2 != null){
            int tmp = newl2.val;
            int v = 0;
            if(flag){
                v = tmp + 1;
            }else {
                v = tmp;
            }
            //需要进位
            if(v / 10 == 1){
                flag = true;
            }
            v = v % 10;
            dummy.next = new ListNode(v);
            dummy = dummy.next;
            newl2 = newl2.next;
        }

        if(flag){
            dummy.next = new ListNode(1);
        }

        return copyDummy.next;

    }

    private ListNode reverseListNode(ListNode head){

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
