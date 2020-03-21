package com.example.leetcode1.copy2;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-03-22 00:07
 */
public class 第83题删除排序链表中的重复元素 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        pre.next = head;

        while (head != null){
            if(head.next != null && head.val == head.next.val){
                while (head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                //这行很关键
//                head = head.next;
                pre.next = head;
            }else {
                head = head.next;
                pre = pre.next;
            }
        }

        return dummy.next;
    }

}
