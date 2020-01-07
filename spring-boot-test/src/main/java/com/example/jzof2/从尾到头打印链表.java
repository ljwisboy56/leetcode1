package com.example.jzof2;

import com.example.letcodeeasy.ListNode;

import java.util.ArrayList;

/**
 * @author yingru.ljw
 * @date 2019-12-22 17:35
 */
public class 从尾到头打印链表 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();

        if(listNode == null){
            return list;
        }
        ListNode tmp = reverseListNode(listNode);
        while (tmp !=null){
            list.add(tmp.val);
            tmp = tmp.next;
        }
        return list;
    }

    /**
     * 链表逆序
     * @param listNode
     * @return
     */
    private ListNode reverseListNode(ListNode listNode) {

        if(listNode == null){
            return null;
        }

        ListNode next = null;
        ListNode pre = null;
        while (listNode !=null){
            next = listNode.next;
            listNode.next = pre;
            pre = listNode;
            listNode = next;
        }
        return pre;
    }
}
