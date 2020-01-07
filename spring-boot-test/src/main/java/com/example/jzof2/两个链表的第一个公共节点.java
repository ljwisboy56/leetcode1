package com.example.jzof2;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2019-12-29 16:04
 */
public class 两个链表的第一个公共节点 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        if(pHead1 == null || pHead2 == null){
            return null;
        }

        ListNode p2Copy = pHead2;

        while (pHead1 != null){
            pHead2 = p2Copy;
            while (pHead2 != null){
                if(pHead1 == pHead2){
                    return pHead1;
                }else {
                    pHead2 = pHead2.next;
                }
            }
            pHead1 = pHead1.next;

        }
        return null;
    }


}
