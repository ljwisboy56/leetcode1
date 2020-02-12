package com.example.leetcode1.leetcodecopy1;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-02-02 16:30
 */
public class K个一组翻转链表 {

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


        ListNode listNode = new K个一组翻转链表().reverseKGroup(l1,3);

        System.out.println(listNode);
    }

    /**
     *  -1 0 1 2 3 4
     * -1 1 2 3 4 5
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null){
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode copyDummy = dummy;
        dummy.next = head;

        //设定一个计数指针从-1开始
        int count = 1;
        while (head != null){
            if(Math.abs(count%k) == 1){
                //记录下当前节点
                ListNode cur = head;
                //记录下当前节点的前驱节点
                ListNode copyCur = cur;
                //定义一个内部计数器目的是找到需要翻转的k个节点
                int innerCount = 1;
                while (cur != null){
                    //如果满足第k个节点则跳出内部循环
                    if(innerCount % k == 0){
                        break;
                    }
                    cur = cur.next;
                    innerCount++;
                }
                if(cur != null && k == innerCount){
                    //留住当前节点的下一个节点
                    ListNode curNext = cur.next;
                    cur.next = null;
                    //翻转当前节点
                    ListNode reverseCopyCur = reverse(copyCur);
                    //记录好翻转节点的头指针
                    ListNode reverseCopyCurCopy = reverseCopyCur;
                    while (reverseCopyCur.next != null){
                        reverseCopyCur = reverseCopyCur.next;
                    }
                    //将原来当前节点的next节点接在翻转节点后面
                    reverseCopyCur.next = curNext;
                    //把当前节点接在前节点后面
                    copyDummy.next = reverseCopyCurCopy;
                }else {
                    return dummy.next;
                }
                count+=k;
                int tc = 0;
                while (copyDummy != null){
                    if(tc == k){
                        break;
                    }
                    tc++;
                    copyDummy = copyDummy.next;
                }
                head = head.next;
            }else {
                count++;
                copyDummy = copyDummy.next;
                head = head.next;
            }
        }

        return dummy.next;

    }

    /**
     * 链表翻转
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head){
        ListNode next = null;
        ListNode pre = null;

        while (head != null){
            next = head.next;
            head.next= pre;
            pre = head;
            head = next;
        }

        return pre;
    }

}
