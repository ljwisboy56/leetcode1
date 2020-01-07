package com.example.letcodeeasy;

import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2019-11-25 01:06
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;


        new ReverseList().ReverseList3(l1);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l5.next = l6;

        ListNode cur = l1;
        ListNode pre = cur;
        pre.next = null;

        ListNode s2 = cur.next;

//        ListNode curNode = cur;
//        curNode.next = null;

//        ListNode cur = l5.next;
        l5.next = null;
        System.out.println(cur.val);




    }


    public ListNode ReverseList(ListNode head) {

        Stack<ListNode> stack = new Stack<>();
        //先把所有的节点压入栈
        while (head != null){
            stack.push(head);
            head = head.next;
        }

        //复制一个指针能抓住保证抓住当前链表不至于丢失
        ListNode copyHead;

        if(!stack.isEmpty()){
            copyHead = stack.pop();
            copyHead.next = null;
        }else {
            return null;
        }

        ListNode cur = copyHead;

        //做链表尾接必须要用2个指针，一个能抓住当前头
        //一个作为当前cur
        while (!stack.isEmpty()){
            ListNode tmp = stack.pop();
            tmp.next =null;
            cur.next = tmp;
            //这步很关键，当cur=tmp这步执行后，链表就会丢失，所以我们需要一个指针，
            // 把cur的链表给抓住，这样才能实现替换
            cur = tmp;
        }
        //为什么最后返回这个，因为内存的对象的值是被cur指针操纵改变的，但是内存一直没有丢，
        //copyHead = stack.pop();，已经让copyHead抓住了内存
        return copyHead;
    }

    public ListNode ReverseList2(ListNode head){
        if(head == null){
            return null;
        }

        ListNode copyHead;

        ListNode cur;

        //1-》2-》3-》4
        //1《-2 3-》4

        cur = head;
        copyHead = head;

        while (cur != null){


            //情况1问：为什么pre=null不会引起cur等于空
            //而pre.next=null 会引起cur.next = null
            //解答和规律：如果操作的是直接引用变量的值的赋值指针为空，是不会引起原指针
            //所指向的内存空间的对象为空的，因为此时pre=null此时操作了引用遍历为空
            //但是如果是pre.next=null则会引起，因为此时.next这个操作已经触发了堆内存的
            //变动，而不是简单的应用变量变动了
            //结论：直接对引用变量=null操作，永远不会引起原对象的堆内存值变动
            //注意：一定是直接操作引用变量本身，而不是对象中的指针next等

//            ListNode pre = cur;
//            pre = null;
//
//            ListNode pre = cur;
//            pre.next = null;

            ListNode s2 = cur.next;
            System.out.println(s2 == cur.next);
//            pre.next = null;

            System.out.println(head);


            //这是第二个值
            ListNode tmp = cur.next;

            //如果这么操作，那么后续的值就都丢了
//            tmp.next = pre;

            System.out.println(cur);





        }

        return copyHead;





    }


    public ListNode ReverseList3(ListNode head) {

        if(head==null)
            return null;
        //head为当前节点，如果当前节点为空的话，那就什么也不做，直接返回null；
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = head;
        //1->2->3->4->5
        //1<-2<-3 4->5
        while(cur!=null){
            //此步是做指针备份的，不要操作备份，直接用最右对角线原则操作原指针
            // 为了让指针能走下去
            //这两步操作的核心能力：能剥离出当前节点的储值域、和当前节点的next链表
            //然后让当前节点的next指针指向前一个节点
            //
            next = cur.next;
            //让当前指针指向前一个
            cur.next = pre;
            //让前一个指针指向当前
            pre = cur;
            //这段是指针操作
            cur = next;
        }
        return pre;
    }

    public ListNode reverse(ListNode head){


        ListNode pre = null;
        ListNode next = null;

        ListNode cur = head;

        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;

    }

}
