package com.example.leetcode1.copy2;

import com.example.letcodeeasy.ListNode;

import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-22 17:02
 */
public class 第92题反转链表2 {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
        ListNode res = new 第92题反转链表2().reverseBetween(l1,1,1);
        System.out.println(res);

    }


    /**
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        int count = 1;
        while (head != null) {
            if (count == m) {
                ListNode copy = head;
                while (head != null) {
                    if (count == n) {
                        ListNode next = head.next;
                        head.next = null;
                        ListNode reverseNode = reverse(copy);
                        ListNode copyReverseNode = reverseNode;
                        while (reverseNode.next != null) {
                            reverseNode = reverseNode.next;
                        }
                        reverseNode.next = next;
                        pre.next = copyReverseNode;
                        return dummy.next;
                    } else {
                        head = head.next;
                        count++;
                    }
                }
            }else {
                head = head.next;
                pre = pre.next;
                count++;
            }
        }
        return dummy.next;

    }

    private ListNode reverse(ListNode head){
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
