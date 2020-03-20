package com.example.leetcode1.copy2;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-03-04 23:32
 */
public class 删除链表的倒数第N个节点 {

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

        ListNode res = new 删除链表的倒数第N个节点().removeNthFromEnd(l1,2);
        System.out.println(res);

    }


    public ListNode removeNthFromEnd(ListNode head, int n) {

        int sum = 0;
        ListNode copy = head;
        while (head != null){
            head = head.next;
            sum++;
        }

        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        head = copy;
        dummy.next = head;

        int count =0;
        while (head != null){
            if(count == sum-n){
                pre.next = head.next;
                break;
            }else {
                pre = pre.next;
                head = head.next;
                count++;
            }
        }

        return dummy.next;
    }

}
