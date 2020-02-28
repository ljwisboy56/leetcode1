package com.example.leetcode3;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-02-26 12:49
 */
public class 移除链表元素 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
//        ListNode l3 = new ListNode(5);
//        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(5);

        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;

        ListNode tmp = new 移除链表元素().removeElements(l1,1);
        System.out.println(tmp);



    }

    /**
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     */
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        while (head != null){
            if(head.val == val){
                while (head != null && head.val == val){
                    head = head.next;
                }
                pre.next = head;
            }else {
                head = head.next;
                pre = pre.next;
            }
        }
        return dummy.next;
    }

}
