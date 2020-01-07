package com.example.jzof;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2019-12-15 17:10
 */
public class FindFirstCommonNode {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;

        n4.next = n5;
        n5.next = n2;

        ListNode res  = new FindFirstCommonNode().FindFirstCommonNode(n1,n4);
        System.out.println(res);

    }



    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        if(pHead1 == null || pHead2 == null){
            return null;
        }

        ListNode p2 = pHead2;

        ListNode res = null;

        boolean flag = false;

        while (pHead1 != null){
            if(!flag){
                while (pHead2 != null){
                    if(pHead1 == pHead2){
                        flag =true;
                        res = pHead1;
                        break;
                    }else {
                        pHead2 = pHead2.next;
                    }
                }
                pHead2 = p2;
                pHead1 = pHead1.next;
            }else {
                break;
            }
        }

        return res;

    }

}
