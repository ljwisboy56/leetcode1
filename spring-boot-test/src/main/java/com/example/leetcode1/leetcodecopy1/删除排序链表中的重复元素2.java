package com.example.leetcode1.leetcodecopy1;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-02-09 23:46
 */
public class 删除排序链表中的重复元素2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        ListNode res = new 删除排序链表中的重复元素2().deleteDuplicates(l1);
        System.out.println(res);

    }


    /**
     * 输入: 1->2->3->3->4->4->5
     * 输出: 1->2->5
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null){
            return null;
        }

        ListNode dummy = new ListNode(-1);

        ListNode pre = dummy;

        dummy.next = head;

        //当head不等于空
        while (head != null){
            //如果我们发现head的下一个节点跟他相同，那么我们找到指导跟他不同那个head节点，然后用pre.next去直接指向他
            if(head.next != null && head.next.val == head.val){
                while (head.next != null && head.next.val == head.val){
                    head = head.next;
                }
                head = head.next;
                pre.next = head;
            }else {
                pre = pre.next;
                head = head.next;
            }
        }

        return dummy.next;

    }


}
