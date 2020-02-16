package com.example.jzof.jzof2;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2019-12-24 01:02
 */
public class 合并两个排序的链表 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n4.next = n5;
        n5.next = n6;

        ListNode head = new 合并两个排序的链表().Merge(n1,n4);
        System.out.println(head);

    }


    public ListNode Merge(ListNode list1, ListNode list2) {

        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        ListNode first = new ListNode(0);

        ListNode head = first;

        while (list1 != null && list2 != null){
            if(list1.val < list2.val){
                head.next = new ListNode(list1.val);
                head = head.next;
                list1 = list1.next;
            }else {
                head.next = new ListNode(list2.val);
                head = head.next;
                list2 = list2.next;
            }
        }

        while (list1 != null){
            head.next = new ListNode(list1.val);
            head = head.next;
            list1 = list1.next;
        }

        while (list2 != null){
            head.next = new ListNode(list2.val);
            head = head.next;
            list2 = list2.next;
        }

        return first.next;

    }

}
