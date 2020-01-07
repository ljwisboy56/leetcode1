package com.example.letcodeeasy;

/**
 * @author yingru.ljw
 * @date 2019-11-26 00:35
 */
public class Merge {


    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head;

        if(list1.val < list2.val){
            list2.next = null;
            head = list2;
        }else if( list1.val > list2.val){
            list1.next = null;
            head = list1;
        }else {
            list1.next = null;
            head = list1;
        }

        while (list1.next != null && list2.next != null){
            ListNode l1next = list1.next;
            ListNode l2next = list2.next;

            if(list1.val < list2.val){
                list2.next = null;
                head.next = list2;
            }else if( list1.val > list2.val){
                list1.next = null;
                head.next = list1;
            }else {
                list1.next = null;
                head.next = list1;
            }

            head.next = head.next;


        }
        return null;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;

        ListNode cur = new ListNode(-1);
        //-------------
//        //代码1：为什么l2.next = new ListNode(6)这行代码执行完成后
//        //cur的对象遍历
//        cur = l2;
//        l2.next = new ListNode(6);
//
//        //代码2：为什么l2 = null这行代码执行完成后
//        //cur的对象没变
//        //规律1：当引用变量在后面的时候，他标识一段对象，当引用变量在前面的时候他标识指针
           //规律2：cur.next的值会随着cur的值变而动态改变，导致与他指向的引用遍历不相等
//        cur = l2;
//        l2 = new ListNode(5);

//        cur.next = l1;
//        cur = l1;
//        System.out.println(cur.next == l1);
//        l1 = l1.next;

        cur = new ListNode(7);
        cur.next = l1;
        cur = l1;



    }


}
