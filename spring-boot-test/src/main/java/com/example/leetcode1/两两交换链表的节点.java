package com.example.leetcode1;

import com.example.letcodeeasy.Heap;
import com.example.letcodeeasy.ListNode;

import java.util.logging.Handler;

/**
 * @author yingru.ljw
 * @date 2020-01-04 16:21
 */
public class 两两交换链表的节点 {

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

        ListNode res = new 两两交换链表的节点().swapPairs(l1);
        System.out.println(res);

    }


    /**
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        //首先定义一个 dummy节点
        ListNode copyDummy = new ListNode(-1);
        //然后进入递归
        doSwap(copyDummy,head);
        //返回值
        return copyDummy.next;

    }

    private void doSwap(ListNode copyDummy ,ListNode head) {
        //找到最后一个dummy的不等于空的节点
        while (copyDummy.next != null){
            copyDummy = copyDummy.next;
        }

        //如果head的下一个节点是空，那么直接赋值到next
        if(head == null || head.next == null){
            copyDummy.next = head;
            return ;
        }

        //存住下下个节点
        ListNode next = head.next.next;
        //将原链表的下下个节点置位空
        head.next.next = null;
        //然后翻转原链表截取的节点
        head = reverseListNode(head);
        //将其接在dummy节点的后面
        copyDummy.next = head;
        //然后递归的进入接下来的节点处理
        doSwap(copyDummy,next);
    }


    private ListNode reverseListNode(ListNode head){

        ListNode pre = null;
        ListNode next = null;

        ListNode cur = head;

        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
