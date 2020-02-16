package com.example.jzof.jzof2;

import com.example.jzof.Clone.RandomListNode;


/**
 * @author yingru.ljw
 * @date 2019-12-28 16:11
 */
public class 复杂链表的复制 {


    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null) {
            return null;
        }

        RandomListNode curNode = pHead;




        //把克隆接节点放在被克隆的节点后面
        while (curNode != null){
            RandomListNode cloneNode = new RandomListNode(curNode.label);
            RandomListNode next = curNode.next;
            curNode.next = cloneNode;
            cloneNode.next = next;
            curNode = next;
        }

        curNode = pHead;

        //复制克隆节点的随机节点
        while (curNode != null){
            curNode.next.random = curNode.random == null ?null:curNode.random.next;
            curNode = curNode.next.next;
        }

        //分离克隆节点和原节点
        curNode = pHead;
        RandomListNode newHead = new RandomListNode(-1);
        //这个地方要用一个东西把头结点抓住，以免迭代的时候复制链表的头结点丢掉
        newHead.next = curNode.next;

        while (curNode != null){
            RandomListNode cloneHead = curNode.next;
            curNode.next = cloneHead.next;
            cloneHead.next = cloneHead.next == null ? null :cloneHead.next.next;
            curNode = curNode.next;
        }
        return newHead.next;

    }


}
