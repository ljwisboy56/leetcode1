package com.example.leetcode1;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-01-08 15:25
 */
public class 旋转链表 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(5);

//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;

        ListNode res = new 旋转链表().rotateRight(l1,0);
        System.out.println(res);



    }

    int target = 0;


    public ListNode rotateRight(ListNode head, int k) {

        if(head == null){
            return null;
        }

        //复原头结点
        ListNode copyHead = head;

        int len = 0;

        this.target = len;
        while (head != null) {
            len++;
            head = head.next;
        }

        int needMoveK = k % len;

        //复原指针
        head = copyHead;

        return doRotateRight(head, needMoveK,len);

    }

    private ListNode doRotateRight(ListNode head, int needMoveK ,int len) {

        ListNode afterK = selectAfterK(head,len-needMoveK);
        ListNode dummy = new ListNode(-1);
        dummy.next =afterK;
        while (afterK != null && afterK.next != null){
            afterK = afterK.next;
        }
        ListNode before = selectBeforeK(head, len-needMoveK);
        if(afterK == null){
            return before;
        }
        afterK.next =before;
        return dummy.next;


    }

    private ListNode selectAfterK(ListNode head,int target) {
        ListNode listNode = new ListNode(-1);
        int count = 0;
        while (head != null){
            if(count == target){
                listNode.next = head;
                break;
            }
            head = head.next;
            count++;
        }
        return listNode.next;

    }

    private ListNode selectBeforeK(ListNode head,int target) {
        ListNode listNode = new ListNode(-1);
        listNode.next = head;
        int count = 0;
        while (head != null){
            count++;
            if(count == target){
                head.next = null;
                break;
            }
            head = head.next;
        }
        return listNode.next;

    }


}
