package com.example.jzof;

import com.example.letcodeeasy.ListNode;

/**
 * @author yingru.ljw
 * @date 2019-12-18 01:49
 */
public class deleteDuplication {

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(2);
        ListNode p4 = new ListNode(4);

        p1.next = p2;
        p2.next = p3;
        p3.next = p4;

        ListNode p5 = p1;

        p5 = p5.next;


        p5.next = null;
        ListNode cur = new deleteDuplication().deleteDuplication(p1);
        System.out.println(cur);

    }


    public ListNode deleteDuplication(ListNode pHead) {

        ListNode Head = new ListNode(0);
        Head.next = pHead;
        ListNode pre  = Head;
        ListNode last = Head.next;
        while (last!=null){
            if(last.next!=null && last.val == last.next.val){
                // 找到最后的一个相同节点
                while (last.next!=null && last.val == last.next.val){
                    last = last.next;
                }
                pre.next = last.next;
                last = last.next;
            }else{
                pre = pre.next;
                last = last.next;
            }
        }
        return Head.next;

    }

    public ListNode delet(ListNode pHead){
        if(pHead == null || pHead.next == null){
            return null;
        }
        ListNode head = new ListNode(0);
        head.next = pHead;
        ListNode cur = pHead;
        ListNode last = pHead.next;
        while (last != null){
            if(last.next != null && last.val == last.next.val ){
                while ((last.next !=null && last.val == last.next.val)){
                    last = last.next;
                }
                cur.next = last;
                last = last.next;
            }else {

            }






        }





        return null;
    }
}
