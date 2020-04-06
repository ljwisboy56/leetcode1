package com.example.leetcode2.copy2;


import com.example.letcodeeasy.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

/**
 * @author yingru.ljw
 * @date 2020-03-28 16:04
 */
public class 第160题相交链表 {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2){
            if(p1 == null){
                p1 = headB;
            }else {
                p1 = p1.next;
            }

            if(p2 == null){
                p2 = headA;
            }else {
                p2 = p2.next;
            }
        }
        return p1;
    }

    /**
     * [4,1,8,4,5]
     * [5,0,1,8,4,5]
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        HashSet<ListNode> map = new HashSet<>();

        while (headA != null){
            map.add(headA);
            headA = headA.next;
        }

        while (headB != null){
            if(map.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }

}
