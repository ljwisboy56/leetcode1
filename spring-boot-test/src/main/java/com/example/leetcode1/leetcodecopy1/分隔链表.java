package com.example.leetcode1.leetcodecopy1;

import com.example.letcodeeasy.ListNode;

import java.util.LinkedList;

/**
 * @author yingru.ljw
 * @date 2020-02-11 00:38
 */
public class 分隔链表 {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(1);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;


        ListNode res = new 分隔链表().partition(l1,3);

    }


    /**
     * 输入: head = 1->4->3->2->5->2, x = 3
     * 输出: 1->2->2->4->3->5
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {

        if(head == null){
            return null;
        }

        LinkedList<Integer> small = new LinkedList<>();
        LinkedList<Integer> big = new LinkedList<>();

        ListNode copy = head;

        while (head != null){
            if(head.val < x){
                small.add(head.val);
                head = head.next;
            }else {
                big.add(head.val);
                head = head.next;
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode copyDummy = dummy;

        while (!small.isEmpty()){
            dummy.next = new ListNode(small.poll());
            dummy = dummy.next;
        }

        while (!big.isEmpty()){
            dummy.next = new ListNode(big.poll());
            dummy = dummy.next;
        }

        return copyDummy.next;


    }
}
