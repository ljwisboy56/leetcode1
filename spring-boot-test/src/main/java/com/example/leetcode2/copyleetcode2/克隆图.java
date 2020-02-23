package com.example.leetcode2.copyleetcode2;

import java.util.*;

/**
 * @author yingru.ljw
 * @date 2020-02-21 19:17
 */
public class 克隆图 {

    public Node cloneGraph(Node node) {

        if(node == null){
            return null;
        }
        Node copy = new Node(node.val,new ArrayList<>());

        HashMap<Node,Node> map = new HashMap<>();
        map.put(node,copy);

        Queue<Node> queue = new LinkedList<>();

        queue.add(node);

        while (!queue.isEmpty()){

            //拿到队列节点
            Node cur = queue.poll();
            //拿到他的子节点
            for(Node tmp : cur.neighbors){
                //如果map里面不包含
                if(!map.containsKey(tmp)){
                    Node clone = new Node(tmp.val,new ArrayList<>());
                    map.put(tmp,clone);
                }
                Node cloned = map.get(tmp);
                List<Node> list = cloned.neighbors;
                Node cloned2 = map.get(tmp);
                list.add(cloned2);
            }
        }
        return copy;

    }

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

}
