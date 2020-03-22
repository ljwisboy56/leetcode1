package com.example.leetcode1.copy2;

import com.example.letcodeeasy.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-22 14:04
 */
public class 第86题分隔链表 {


    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return null;
        }
        List<Integer> small = new ArrayList<>();
        List<Integer> big = new ArrayList<>();

        ListNode dummy = new ListNode(-1);
        ListNode copy = dummy;

        while (head != null){
            if(head.val < x){
                small.add(head.val);
            }else {
                big.add(head.val);
            }
            head = head.next;
        }

        for(Integer tmp : small){
            dummy.next = new ListNode(tmp);
            dummy = dummy.next;
        }
        for(Integer tmp : big){
            dummy.next = new ListNode(tmp);
            dummy = dummy.next;
        }
        return copy.next;

    }

}
