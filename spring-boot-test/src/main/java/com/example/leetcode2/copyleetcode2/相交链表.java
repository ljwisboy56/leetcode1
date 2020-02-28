package com.example.leetcode2.copyleetcode2;

import com.example.letcodeeasy.ListNode;
import java.util.HashSet;

/**
 * @author yingru.ljw
 * @date 2020-02-22 19:00
 */
public class 相交链表 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

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

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        if(headA == null || headB == null){
            return null;
        }

        ListNode p1 = headA;
        ListNode p2 = headB;

        while ( p1 != p2){

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

}
