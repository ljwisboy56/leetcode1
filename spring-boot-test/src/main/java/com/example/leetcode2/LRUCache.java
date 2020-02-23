package com.example.leetcode2;

import java.util.HashMap;

/**
 * @author yingru.ljw
 * @date 2020-02-16 16:25
 */
public class LRUCache {

    /**
     * 头节点
     */
    private DLinkedQueue head;
    /**
     * 尾节点
     */
    private DLinkedQueue tail;

    private int size = 0;

    private int capacity = 0;

    private HashMap<Integer,DLinkedQueue> cache = new HashMap<>();


    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedQueue();
        tail = new DLinkedQueue();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {

        DLinkedQueue curNode = cache.get(key);

        if(curNode == null){
            return -1;
        }

        //将队列移到最前这样才能保证LRU最近最少使用
        moveToHead(curNode);

        return curNode.value;


    }

    public void put(int key, int value) {

        DLinkedQueue curNode = cache.get(key);
        if(curNode == null){
            DLinkedQueue node = new DLinkedQueue();
            node.key = key;
            node.value = value;

            cache.put(key,node);
            //队列所以新元素要加到队列头
            addHeadNode(node);

            size++;

            if(size > capacity){
                //同时操作缓存和链表
                DLinkedQueue curTail = popTail();
                cache.remove(curTail.key);
                size--;
            }
        }else {
            //更新他的值
            curNode.value = value;
            //移到堆头
            moveToHead(curNode);
        }

    }


    /**
     * 双端队列
     */
    class DLinkedQueue{
        int key ;
        int value ;
        DLinkedQueue pre;
        DLinkedQueue next;
    }

    private void addHeadNode(DLinkedQueue node){
        //指向头结点
        node.pre = head;
        DLinkedQueue tmp = head.next;
        head.next = node;
        node.next = tmp;
        tmp.pre = node;
    }

    /**
     * 这个要注意移除这个节点肯定在队列里面
     * @param node
     */
    private void removeNode(DLinkedQueue node){

        DLinkedQueue pre = node.pre;
        DLinkedQueue next = node.next;

        pre.next = next;
        next.pre = pre;

    }

    private void moveToHead(DLinkedQueue node){
        //先删除这个节点
        removeNode(node);
        //再添加到对头
        addHeadNode(node);
    }

    /**
     * 删除的时候会维持这个节点的链表指针的
     * @return
     */
    private DLinkedQueue popTail(){
        DLinkedQueue tmpTail = tail.pre;
        removeNode(tmpTail);
        return tmpTail;
    }


}
