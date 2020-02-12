package com.example.leetcode1.leetcodecopy1;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-02-11 10:32
 */
public class 翻转链表2 {

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

        ListNode res = new 翻转链表2().reverseBetween(l1,2,4);
        System.out.println(res);

    }


    /**
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {

        int count =1 ;
        ListNode copy = head;

        ListNode dummy = new ListNode(-1);
        ListNode copyDummy = dummy;

        dummy.next = copy;

        while (head != null){
            if(m == count){
                int innerCount = count;
                ListNode copyHead = head;
                ListNode next = null;
                while (copyHead != null){
                    if(innerCount == n){
                        next = copyHead.next;
                        copyHead.next = null;
                        break;
                    }
                    innerCount++;
                    copyHead = copyHead.next;
                }
                ListNode afterReverseNode = reverseNode(head,n-m);
                if(afterReverseNode == null){
                    return dummy.next;
                }
                ListNode copyReverseNodeNext = afterReverseNode;
                while (afterReverseNode.next != null){
                    afterReverseNode = afterReverseNode.next;
                }
                afterReverseNode.next = next;
                copyDummy.next = copyReverseNodeNext;
                return dummy.next;
            }
            count++;
            copyDummy = copyDummy.next;
            head = head.next;
        }
        return dummy.next;

    }

    private ListNode reverseNode(ListNode head,int n){

        int count = 1;

        ListNode pre = null;
        ListNode next = null;

        while (head != null){
            count++;
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;

    }

}
