package com.example.leetcode2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yingru.ljw
 * @date 2020-02-15 15:22
 */
public class 克隆图 {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(1);
        Node node3 = new Node(1);
        Node node4 = new Node(1);
        List<Node> copyList1 = new ArrayList<>();
        List<Node> copyList2 = new ArrayList<>();
        List<Node> copyList3 = new ArrayList<>();
        List<Node> copyList4 = new ArrayList<>();

        copyList1.add(node2);
        copyList1.add(node3);

        node1.neighbors = copyList1;

        copyList2.add(node1);
        copyList2.add(node4);

        node2.neighbors = copyList2;

        copyList3.add(node1);
        copyList3.add(node2);

        node3.neighbors = copyList3;

        copyList4.add(node2);
        copyList4.add(node3);

        node4.neighbors = copyList4;

        Node root = new 克隆图().cloneGraph(node1);

        System.out.println(root);
    }

    /**
     * 节点--克隆节点
     */
    HashMap<Node,Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        return bfs(node);
    }

    private Node bfs(Node node) {

        //复制这个元素
        Node copyCur = new Node(node.val,new ArrayList<>());

        map.put(node,copyCur);

        Queue<Node> queue = new LinkedBlockingQueue<>();

        queue.add(node);

        while (!queue.isEmpty()){
            //拿出第一个元素
            Node cur = queue.poll();
            for (Node tmp : cur.neighbors){
                //拿到copy头节点的无向边，将tmp集合其加进去
                if(!map.containsKey(tmp)){
                    Node copy = new Node(tmp.val,new ArrayList<>());
                    //建立源结点-copy之间的关系
                    map.put(tmp,copy);
                    queue.add(tmp);
                }
                //拿到当前的节点的克隆节点的边
                List<Node> list = map.get(cur).neighbors;
                //把当前节边的克隆节点加进去
                list.add(map.get(tmp));
            }
        }

        return copyCur;
    }


    static class Node {
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
