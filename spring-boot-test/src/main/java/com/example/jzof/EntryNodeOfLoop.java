package com.example.jzof;

import com.example.letcodeeasy.ListNode;

import java.util.ArrayList;

/**
 * @author yingru.ljw
 * @date 2019-12-18 01:22
 */
public class EntryNodeOfLoop {


    /**
     *
     * 1->2->3->4
     *       ↑  ↓
     *       6 ←5
     *
     */
    private ArrayList<ListNode> listNodes = new ArrayList<>();

    public synchronized ListNode EntryNodeOfLoop(ListNode pHead) {

        if(pHead == null){
            return null;
        }

        //补偿1
        ListNode p1 = pHead;
        //步长2
        ListNode p2 = pHead;

        while (true) {

            p1 = p1.next;
            if(p1 == null){
                return null;
            }
            if(p2.next != null){
                p2 = p2.next.next;
            }
            if(p2 == null){
                return null;
            }

            if(p1 == p2){
                p1 = pHead;
                while (p1 != p2){
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }

    }

}
