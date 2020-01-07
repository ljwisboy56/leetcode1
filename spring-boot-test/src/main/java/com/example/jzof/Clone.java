package com.example.jzof;

/**
 * @author yingru.ljw
 * @date 2019-12-01 22:31
 */
public class Clone {


    public static class RandomListNode {
        public int label;
        public RandomListNode next = null;
        public RandomListNode random = null;

        public RandomListNode(int label) {
            this.label = label;
        }
    }


    public RandomListNode Clone(RandomListNode pHead){

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
        //这个地方要用一个东西把头结点抓住，以免迭代的时候复制链表的头结点丢掉
        RandomListNode pcHead = curNode.next;
        while (curNode != null){
            RandomListNode cloneHead = curNode.next;
            curNode.next = cloneHead.next;
            cloneHead.next = cloneHead.next == null ? null :cloneHead.next.next;
            curNode = curNode.next;
        }
        return pcHead;
    }
}
