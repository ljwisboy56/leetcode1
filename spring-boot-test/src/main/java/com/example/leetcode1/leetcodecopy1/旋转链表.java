package com.example.leetcode1.leetcodecopy1;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2020-02-07 14:34
 */
public class 旋转链表 {

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

        ListNode res = new 旋转链表().rotateRight(l1,5);
        System.out.println(res);


    }

    public ListNode rotateRight(ListNode head, int k) {

        if(head == null) {
            return null;
        }

        int count = 0;

        ListNode copy = head;

        int sum = 0;

        //先统计出有多少节点
        while (head != null){
            sum++;
            head = head.next;
        }

        head = copy;


        while (head != null){
            count++;
            //当旋转是0和本身就不旋转
            if(sum - (k%sum) == 0 || sum-(k%sum) == sum){
                return copy;
            }
            if(count == sum - (k%sum)){
                //抓住4 5这个节点
                ListNode newHead = head.next;
                head.next = null;
                ListNode copyNewHead = newHead;
                while (newHead.next != null){
                    newHead = newHead.next;
                }
                newHead.next = copy;
                return copyNewHead;
            }
            head = head.next;
        }

        return head;
    }


}
