package com.example.leetcode3.copy2;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-03-30 00:21
 */
public class 第203题移除链表元素 {

    /**
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     */

    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }

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
                pre = pre.next;
                head = head.next;
            }
        }
        return dummy.next;

    }

}
