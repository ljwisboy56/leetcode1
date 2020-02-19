package com.example.leetcode2;

import com.example.letcodeeasy.ListNode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author yingru.ljw
 * @date 2020-02-17 15:06
 */
public class 相交链表 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB){

        if(headA == null || headB == null){
            return null;
        }


        ListNode pA = headA;
        ListNode pB = headB;


        while (pA != pB){
            if(pA == null){
                pA = headB;
            }else{
                pA = pA.next;
            }


            if(pB == null){
                pB = headA;
            }else {
                pB = pB.next;
            }
        }

        return pA;

    }


    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        HashSet<ListNode> set = new HashSet<>();

        while (headA != null){
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null){
            if(set.contains(headB)){
                return headB;
            }else {
                headB = headB.next;
            }
        }

        return null;

    }

}
