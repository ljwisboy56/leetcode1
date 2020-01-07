package com.example.leetcode1;

import com.example.letcodeeasy.ListNode;

import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-01-04 16:01
 */
public class 合并k个排序链表 {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);

        l4.next = l5;
        l5.next = l6;


        ListNode res = new 合并k个排序链表().mergeSort(l1,l4);
        System.out.println(res);



    }

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0){
            return null;
        }

        ListNode head = lists[0];
        for(int i = 1;i < lists.length;i++){
            head = mergeSort(head,lists[i]);
        }
        return head;
    }


    public ListNode mergeSort(ListNode l1,ListNode l2){

        ListNode head = new ListNode(-1);
        ListNode copyHead = head;

        while (l1 != null && l2 != null){

            if(l1 != null && l2 != null){
                if(l1.val <= l2.val){
                    head.next = l1;
                    head = head.next;
                    l1 = l1.next;
                }
            }

            if(l1 != null && l2 != null){
                if(l1.val >= l2.val){
                    head.next = l2;
                    head = head.next;
                    l2 = l2.next;
                }
            }

        }

        while (l1 != null){
            head.next = l1;
            l1 = l1.next;
            head = head.next;
        }

        while (l2 != null){
            head.next = l2;
            l2 = l2.next;
            head = head.next;
        }

        return copyHead.next;
    }

}
