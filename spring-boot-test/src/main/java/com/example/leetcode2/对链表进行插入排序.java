package com.example.leetcode2;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-02-16 17:09
 */
public class 对链表进行插入排序 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(6);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(2);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode res = new 对链表进行插入排序().insertionSortList(l1);
        System.out.println(res);
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
        // 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
        // 每次迭代完成，从插入元素为止，该链表可以被认为已经部分排序
        // 重复直到所有输入数据插入完为止

        // 1.遍历并与前面已经有序的序列向前逐一比较排序，找到合适为止插入

        // 定义三个指针 pre, cur, lat
        //pre    cur    lat
        // dummy  ->  4  ->  2  ->  5  ->  3  ->  null

        // 创建 dummy 节点，用于遍历链表
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null) {

            //拿到下一个节点
            ListNode next = cur.next;

            if(next != null && next.val < cur.val){
                while (pre.next != null && pre.next.val < next.val){
                    pre = pre.next;
                }
                ListNode tmp = pre.next;
                pre.next = next;
                cur.next = next.next;
                next.next = tmp;
                pre = dummy;
            }else {
                cur = next;
            }
        }
        return dummy.next;

    }


}
