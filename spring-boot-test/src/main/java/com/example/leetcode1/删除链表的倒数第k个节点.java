package com.example.leetcode1;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-01-01 22:53
 */
public class 删除链表的倒数第k个节点 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
        ListNode res = new 删除链表的倒数第k个节点().removeNthFromEnd(l1,1);
        System.out.println(res);

    }


    /**
     * 倒数第2个 ，处理正数第3个(5-2);
     * 1 - 2 - 3 - 4 - 5
     *
     * 倒数第1个 ，处理正数第0个(1-1);
     * 1
     *
     * 倒数第2个，处理正数第个0个(2-2）
     * 1 - 2
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null){
            return null;
        }

        ListNode node = head;

        int count = 0;
        while (head != null){
            count++;
            head = head.next;
        }

        head = node;

        ListNode newHead = new ListNode(-1);
        ListNode copyHead = newHead;
        newHead.next = head;
        int newCount = -1;
        while (newHead != null){
            newCount++;
            if(newCount == count-n){
                if(newHead.next != null){
                    newHead.next = newHead.next.next;
                }
            }
            newHead = newHead.next;
        }
        return copyHead.next;
    }
}
