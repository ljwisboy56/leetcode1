package com.example.leetcode2.copy2;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-03-26 21:46
 */
public class 第143题重排链表 {

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

        new 第143题重排链表().reorderList(l1);

        System.out.println(l1);
    }

    /**
     * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
     * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
     * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
     */
    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        head.next = reverse(head.next);
        head = head.next;
        reorderList(head);

    }

    private ListNode reverse(ListNode cur){
        ListNode pre = null;
        ListNode next = null;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
