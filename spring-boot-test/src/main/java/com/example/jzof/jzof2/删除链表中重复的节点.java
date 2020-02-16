package com.example.jzof.jzof2;

import com.example.letcodeeasy.ListNode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yingru.ljw
 * @date 2019-12-29 19:50
 */
public class 删除链表中重复的节点 {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;


        ListNode listNode = new 删除链表中重复的节点().deleteDuplication(l1);
        System.out.println(listNode);


    }

    LinkedHashMap<ListNode,Integer> map = new LinkedHashMap<>();

    /**
     * 链表1->2->3->3->4->4->5 处理后为 1->2->5
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {

        if(pHead == null){
            return null;
        }

        while (pHead != null){
            if(map.containsKey(pHead)){
                Integer v = map.get(pHead);
                map.put(pHead,v+1);
            }else {
                map.put(pHead,1);
            }
            pHead = pHead.next;
        }

        ListNode newHead = new ListNode(-1);
        ListNode head = newHead;

        for (Map.Entry<ListNode,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                ListNode tmp = entry.getKey();
                tmp.next = null;
                newHead.next = tmp;
            }
            if(newHead.next != null){
                newHead = newHead.next;
            }
        }

        return head.next;

    }
}
