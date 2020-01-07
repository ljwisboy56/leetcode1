package com.example.jzof;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2019-11-25 10:05
 */
public class ListNodeTest {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

//        //实验1
//        ListNode tmp = l1;
//        //他们两个指向同一个对象一定相等
//        System.out.println(tmp == l1);
//
//        l1.next = null;
//        //结果 tmp.next = null ListNode tmp没有next节点只保留原节点的值
//        System.out.println(tmp.next);
//
//        //实验2
//        ListNode tmp2 = l1.next;
//        l1.next = null;
//        //结果 tmp2 = null ListNode tmp2直接为空
//        System.out.println(tmp2);

        //实验3
        ListNode dummy = new ListNode(-1);
        ListNode tmp3 = dummy;

        tmp3.next = l1;
        tmp3 = tmp3.next;
        l1 = l1.next;

        tmp3.next = l1;
        tmp3 = tmp3.next;
        l1 = l1.next;



    }


    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null && list2 == null) return null;
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode dummy = new ListNode(-1);
        ListNode list = dummy;
        while(list1 != null && list2 != null) {
            if(list1.val > list2.val) {
                list.next = list2;
                list = list.next;
                list2 = list2.next;
            } else {
                list.next = list1;
                list = list.next;
                list1 = list1.next;
            }
        }
        while(list1 != null) {
            list.next = list1;
            list = list.next;
            list1 = list1.next;
        }
        while(list2 != null) {
            list.next = list2;
            list = list.next;
            list2 = list2.next;
        }
        return dummy.next;
    }
}
