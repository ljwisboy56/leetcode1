package com.example.leetcode3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yingru.ljw
 * @date 2020-02-26 14:09
 */
public class 课程表 {


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }

        // 特判
        int pLen = prerequisites.length;
        if (pLen == 0) {
            return true;
        }


        //入度数组,用来记录每个节点的入读数
        int[] inDegree = new int[numCourses];

        //需要一个邻接链表，用来存储每个节点的有向边，并且完成邻接表创建
        HashSet<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new HashSet<>();
        }

        //初始化每个节点的入读
        for (int i = 0; i < prerequisites.length ; i++) {
            //拿到每个边的入读节点，并且++，根据调解每个2维数组的第0个就是入读节点
            inDegree[prerequisites[i][0]]++;
            //然后拿出2维数组的第2个节点初始化邻接表
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        /**
         * 一定找出一个入读为0的至于是哪个都行
         */
        for (int i = 0; i < numCourses ; i++) {
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }

        //开始广度优先遍历
        int res = 0;
        while (!queue.isEmpty()){
            Integer top = queue.poll();
            res++;
            //找出当前出队节点的所有后继节点
            for(int sucessor : adj[top]){
                //找到这个节点对应的入读,减去1
                inDegree[sucessor]--;
                //判断是否达到入队条件即入读为0
                if(inDegree[sucessor] == 0){
                    queue.add(sucessor);
                }
            }
        }
        return res == numCourses;

    }

}
