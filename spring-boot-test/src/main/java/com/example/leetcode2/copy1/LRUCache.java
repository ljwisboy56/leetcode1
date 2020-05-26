package com.example.leetcode2.copy1;

import java.util.HashMap;

/**
 * @author yingru.ljw
 * @date 2020-02-22 12:37
 */
public class LRUCache {

    DqNode head;

    DqNode tail;

    private HashMap<Integer,DqNode> map;

    int capacity = 0;

    public LRUCache(int capacity) {
        head = new DqNode(-1,-1);
        tail = new DqNode(-1,-1);
        head.next = tail;
        tail.pre = head;
        this.map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        DqNode curNode = map.get(key);

        if(curNode == null){
            return -1;
        }

        //将队列移到最前这样才能保证LRU最近最少使用
        setHead(curNode);

        return curNode.val;

    }

    public void put(int key, int value) {

        DqNode node = map.get(key);
        if(node == null){
            DqNode newNode = new DqNode(key,value);
            map.put(key,newNode);
            addHeadNode(newNode);
            if(map.size() > capacity){
                DqNode k = popTail();
                map.remove(k.key);
            }
        }else {
            node.val = value;
            setHead(node);
        }
    }

    private void setHead(DqNode node){
        removeNode(node);
        addHeadNode(node);
    }

    private void addHeadNode(DqNode node){
        //指向头结点
        node.pre = head;
        DqNode tmp = head.next;
        head.next = node;
        node.next = tmp;
        tmp.pre = node;
    }


    private void removeNode(DqNode node){
        DqNode pre = node.pre;
        DqNode next = node.next;
        pre.next = next;
        next.pre= pre;
    }

    private DqNode popTail(){
        DqNode pre = tail.pre;
        removeNode(pre);
        return pre;
    }


    class DqNode{
        DqNode pre = null;
        DqNode next = null;
        int key;
        int val ;
        DqNode(int key,int val){
            this.key = key;
            this.val = val;
        }
    }


}
