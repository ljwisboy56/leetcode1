package com.example.leetcode2.copy2;

import java.util.HashMap;

/**
 * @author yingru.ljw
 * @date 2020-03-26 22:20
 */
public class 第146题LRU缓存机制 {

    HashMap<Integer,Node> map;
    int size = 0;

    Node head;
    Node tail;

    public 第146题LRU缓存机制(int capacity) {
        this.map = new HashMap<>();
        this.size = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node tmp = map.get(key);
        if(tmp == null){
            return -1;
        }
        //移动到对头
        setHead(tmp);
        return tmp.value;
    }

    public void put(int key, int value) {

        Node tmp = map.get(key);
        if(tmp == null){
            Node newNode = new Node(key,value);
            map.put(key,newNode);
            moveHead(newNode);
            if(map.size() > size){
                Node tailNode = popTail();
                map.remove(tailNode.key);
            }
        }else {
            //已经存在的话要更新值
            tmp.value = value;
            setHead(tmp);
        }
    }

    private void moveHead(Node cur){
        Node next = head.next;
        head.next = cur;
        cur.next = next;
        cur.pre = head;
        next.pre = cur;
    }

    private void setHead(Node node){
        //先把这个节点删除
        removeNode(node);
        moveHead(node);
    }

    private void removeNode(Node cur){
        Node pre = cur.pre;
        Node next = cur.next;
        pre.next = next;
        next.pre = pre;
    }

    private Node popTail(){
        Node pre = tail.pre;
        removeNode(pre);
        return pre;
    }

    class Node{
        Node next;
        Node pre;
        int key;
        int value;
        Node(int key,int value){
            this.key = key;
            this.value = value;
        }
        Node(){

        }

    }

}
