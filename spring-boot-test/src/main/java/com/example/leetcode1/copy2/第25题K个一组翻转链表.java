package com.example.leetcode1.copy2;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-03-16 22:37
 */
public class 第25题K个一组翻转链表 {

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

        ListNode res = new 第25题K个一组翻转链表().reverseKGroup(l1,2);
        System.out.println(res);


    }


    /**
     * 给你这个链表：1->2->3->4->5
     *
     * 当 k = 2 时，应当返回: 2->1->4->3->5
     *
     * 当 k = 3 时，应当返回: 3->2->1->4->5
     * pre         head
     * -1->2->1->4->3->5
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode pre = dummy;

        int count = 1;
        while (head != null){
            if(count == k){
                ListNode next = head.next;
                head.next = null;
                //4-1-2翻转链表
                ListNode reverseNode = reverseNode(pre.next);
                ListNode cur = reverseNode;
                while (cur.next != null){
                    cur = cur.next;
                }
                pre.next = reverseNode;
                pre = cur;
                cur.next = next;
                head = next;
                count = 1;
            }else {
                head = head.next;
                count++;
            }
        }
        return dummy.next;
    }

    private ListNode reverseNode(ListNode head){
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
