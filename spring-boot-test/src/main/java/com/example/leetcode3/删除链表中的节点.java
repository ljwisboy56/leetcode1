package com.example.leetcode3;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-02-28 12:44
 */
public class 删除链表中的节点 {

    /**
     * 思路就是把下一个节点的值赋给当前节点，然后将当前节点指向下下个节点
     * 输入: head = [4,5,1,9], node = 5
     * 输出: [4,1,9]
     * @param node
     */
    public void deleteNode(ListNode node) {

      node.val = node.next.val;

      node.next = node.next.next;




    }

}
