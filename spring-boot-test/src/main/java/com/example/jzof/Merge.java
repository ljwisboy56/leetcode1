package com.example.jzof;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2019-11-26 23:29
 */
public class Merge {

    public ListNode Merge(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while (list1 != null && list2 != null){

            if(list1.val > list2.val){
                head.next = list2;
                head = head.next;
                list2 = list2.next;
            }else  {
                head.next = list1;
                head = head.next;
                list1 = list1.next;
            }
        }

//        //这种做法时间复杂度低，但是能很好的学习到指针链表移位操作的精髓
//        while (list1 != null){
//            head.next = list1;
//            head = head.next;
//            list1 = list1.next;
//        }


        if(list1 == null){
            head.next = list2;
        }
        if(list2 == null){
            head.next = list1;
        }

        return dummy.next;


    }
}
