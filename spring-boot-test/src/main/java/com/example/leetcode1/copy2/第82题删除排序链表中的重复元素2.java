package com.example.leetcode1.copy2;

import com.example.letcodeeasy.ListNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author yingru.ljw
 * @date 2020-03-21 23:50
 */
public class 第82题删除排序链表中的重复元素2 {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode res = new 第82题删除排序链表中的重复元素2().deleteDuplicates(l1);
        System.out.println(res);

    }


    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        pre.next = head;

        while (head != null){
            if(head.next != null && head.val == head.next.val){
                while (head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                //这行很关键
//                head = head.next;
                pre.next = head;
            }else {
                head = head.next;
                pre = pre.next;
            }
        }

        return dummy.next;
    }


    /**
     * 用map来做，时间复杂度2O(N),空间复杂度O（n）
     */
    TreeMap<Integer,Integer> map = new TreeMap<>();
    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null){
            return null;
        }

        while (head != null){
            map.put(head.val,map.getOrDefault(head.val,0)+1);
            head = head.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode copy = dummy;

        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                dummy.next = new ListNode(entry.getKey());
                dummy = dummy.next;
            }
        }

        return copy.next;
    }

}
