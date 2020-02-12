package com.example.leetcode1.leetcodecopy1;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-02-01 22:40
 */
public class 删除链表的倒数第N个节点 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;

        ListNode res = new 删除链表的倒数第N个节点().removeNthFromEnd(l1,1);
        System.out.println(res);



    }

    /**
     * 1 2 3 4 5 倒数第2个 整数第 len-n+1 个
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null){
            return null;
        }

        int len = 0;

        ListNode copy = head;
        //统计出有多少节点
        while (head !=null){
            head = head.next;
            len++;
        }

        head = copy;

        ListNode dummy = new ListNode(-1);
        ListNode copyDummy = dummy;

        dummy.next = head;

        int index = -1;
        while (copyDummy != null){
            if(index == len - n -1){
                //这就是我们的当前要删除的节点
                ListNode curNext = copyDummy.next;
                //跳过这个节点
                copyDummy.next = curNext.next;
                copyDummy = copyDummy.next;
                index++;
            }else {
                copyDummy = copyDummy.next;
                index++;
            }

        }

        return dummy.next;
    }
}
