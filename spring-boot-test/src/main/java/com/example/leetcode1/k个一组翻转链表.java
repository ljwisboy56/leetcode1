package com.example.leetcode1;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-01-04 18:54
 */
public class k个一组翻转链表 {

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

        ListNode res = new k个一组翻转链表().reverseKGroup(l1,3);
        System.out.println(res);

    }

    int target = 0;

    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null){
            return null;
        }

        if(k <= 0){
            return head;
        }

        this.target = k;

        ListNode dummy = new ListNode(-1);

        doReverseGroup(dummy,head);

        return dummy.next;

    }

    private void doReverseGroup(ListNode dummy, ListNode head) {
        //找到最后一个不为空的节点
        while (dummy.next != null){
            dummy = dummy.next;
        }
        //判断是否返回
        if(judge(head)){
            dummy.next = head;
            return;
        }
        //以上两步都是终止条件，下面真正进入递归该做什么
        //存储k个节点之后的节点
        ListNode tmpKAfter = selectAfterK(head);
        //找到前k个节点
        ListNode tmpKBefore = selectBeforeK(head);
        //交换前k个链表节点
        head = reverseListNode(tmpKBefore);
        //接在dummy后面
        dummy.next = head;
        //进入递归
        doReverseGroup(dummy,tmpKAfter);

    }

    private boolean judge(ListNode head) {

        ListNode copy = head;
        //统计后面有几个节点
        int count = 0;
        while (head != null){
            count++;
            head = head.next;
        }
        if(count < target){
            return true;
        }
        head = copy;
        return false;
    }

    private ListNode selectBeforeK(ListNode head) {
        ListNode listNode = new ListNode(-1);
        listNode.next = head;
        int count = 0;
        while (head != null){
            count++;
            if(count == target){
                head.next = null;
                break;
            }
            head = head.next;
        }
        return listNode.next;

    }

    private ListNode selectAfterK(ListNode head) {
        ListNode listNode = new ListNode(-1);
        int count = 0;
        while (head != null){
            count++;
            if(count == target){
                head = head.next;
                listNode.next = head;
                break;
            }
            head = head.next;
        }
        return listNode.next;

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
