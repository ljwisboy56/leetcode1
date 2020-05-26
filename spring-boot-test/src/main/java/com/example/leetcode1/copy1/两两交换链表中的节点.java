package com.example.leetcode1.copy1;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-02-02 16:00
 */
public class 两两交换链表中的节点 {

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


        ListNode listNode = new 两两交换链表中的节点().swapPairs(l1);
        System.out.println(listNode);


    }


    public ListNode swapPairs(ListNode head) {

        if(head == null){
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode copyDummy = dummy;
        dummy.next = head;

        //设定一个计数指针从-1开始
        int count = -1;
        while (copyDummy != null){
            if(Math.abs(count%2) == 1){
                //拿到前一个节点的下一个节点也就是当前节点
                ListNode cur = copyDummy.next;
                //记录下当前节点
                ListNode copyCur = cur;
                //定义一个内部计数器目的是找到需要翻转的k个节点
                int innerCount = 1;
                while (cur != null){
                    //如果满足第k个节点则跳出内部循环
                    if(innerCount % 2 == 0){
                        break;
                    }
                    cur = cur.next;
                    innerCount++;
                }
                if(cur != null){
                    ListNode curNext = cur.next;
                    cur.next = null;
                    ListNode reverseCopyCur = reverse(copyCur);
                    ListNode reverseCopyCurCopy = reverseCopyCur;
                    while (reverseCopyCur.next != null){
                        reverseCopyCur = reverseCopyCur.next;
                    }
                    reverseCopyCur.next = curNext;
                    copyDummy.next = reverseCopyCurCopy;
                }
            }
            count++;
            copyDummy = copyDummy.next;
        }

        return dummy.next;

    }

    /**
     * 链表翻转
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head){
        ListNode next = null;
        ListNode pre = null;

        while (head != null){
            next = head.next;
            head.next= pre;
            pre = head;
            head = next;
        }

        return pre;
    }
}
