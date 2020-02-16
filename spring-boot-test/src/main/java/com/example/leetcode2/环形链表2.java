package com.example.leetcode2;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-02-16 13:08
 */
public class 环形链表2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);

        l1.next = l2;

        ListNode res = new 环形链表2().detectCycle(l1);
        System.out.println(res);


    }


    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }

        ListNode copy = head;

        ListNode p1 = head.next;
        ListNode p2 = head.next.next;

        //先找到第一次相遇的节点
        ListNode huan = null;
        while (p1 != null && p2 != null){
            if(p1 == p2){
                huan = p1;
                break;
            }else {
                p1 = p1.next;
                if(p2.next != null){
                    p2 = p2.next.next;
                }else {
                    p2 = null;
                }
            }
        }

        head = copy;

        if(huan == null){
            return null;
        }

        while (head != huan){
            head = head.next;
            huan = huan.next;
        }

        return head;

    }

}
