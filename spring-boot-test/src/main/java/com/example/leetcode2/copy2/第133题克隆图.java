package com.example.leetcode2.copy2;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yingru.ljw
 * @date 2020-03-26 00:26
 */
public class 第133题克隆图 {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        return bfs(node);
    }

    private Node bfs(Node node) {

        Map<Node,Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Node copyNode = new Node(node.val,new ArrayList<>());
        map.put(node,copyNode);

        while (!queue.isEmpty()){
            Node cur = queue.poll();
            for(Node tmp : cur.neighbors){
                if(!map.containsKey(tmp)){
                    Node copy = new Node(tmp.val,new ArrayList<>());
                    map.put(tmp,copy);
                    queue.add(tmp);
                }
                List<Node> list = map.get(cur).neighbors;
                list.add(map.get(tmp));
            }
        }
        return copyNode;
    }

}
