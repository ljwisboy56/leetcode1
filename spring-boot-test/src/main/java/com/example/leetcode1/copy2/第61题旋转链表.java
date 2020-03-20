package com.example.leetcode1.copy2;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-03-19 23:03
 */
public class 第61题旋转链表 {

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
        ListNode res = new 第61题旋转链表().rotateRight(l1,2);
        System.out.println(res);


    }

    /**
     * 输入: 1->2->3->4->5->NULL, k = 2
     * 输出: 4->5->1->2->3->NULL
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null){
            return null;
        }

        int size = 0;
        ListNode copy = head;
        while (head != null){
            head = head.next;
            size++;
        }

        //记录从1开始
        int count = 1;
        head = copy;
        ListNode next = null;
        while (head != null){
            if(count == size - (k%size)){
                next = head.next;
                head.next = null;
                break;
            }else {
                head = head.next;
                count++;
            }
        }

        if(next == null){
            return copy;
        }

        ListNode copyNext = next;
        while (next.next != null){
            next = next.next;
        }
        next.next = copy;
        return copyNext;
    }

}
