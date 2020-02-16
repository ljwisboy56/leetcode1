package com.example.jzof.jzof2;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2019-12-29 18:45
 */
public class 链表中环的入口点 {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l1;

        ListNode l6 = new ListNode(6);


        ListNode listNode = new 链表中环的入口点().EntryNodeOfLoop(l1);
        System.out.println(listNode);


    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {

        if(pHead == null || pHead.next == null || pHead.next.next == null){
            return null;
        }

        ListNode one = pHead.next;

        ListNode two = pHead.next.next;

        while (one != two){
            one = one.next;
            if(one == null){
                return null;
            }

            if(two.next == null){
                return null;
            }
            two = two.next.next;
            if(two == null){
                return null;
            }
        }

        one = pHead;
        while (two != one){
            one = one.next;
            two = two.next;
        }

        return one;

    }

    public ListNode EntryNodeOfLoop2(ListNode pHead){

        ///

        if(pHead==null|| pHead.next==null|| pHead.next.next==null)return null;

        ListNode fast=pHead.next.next;

        ListNode slow=pHead.next;

        /////先判断有没有环

        while(fast!=slow){

            if(fast.next!=null&& fast.next.next!=null){

                fast=fast.next.next;

                slow=slow.next;

            }else{

                //没有环,返回

                return null;

            }

        }

        //循环出来的话就是有环，且此时fast==slow.

        fast=pHead;

        while(fast!=slow){

            fast=fast.next;

            slow=slow.next;

        }

        return slow;

    }


}
