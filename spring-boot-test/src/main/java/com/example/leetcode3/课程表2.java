package com.example.leetcode3;

import java.util.*;

/**
 * @author yingru.ljw
 * @date 2020-02-26 23:10
 */
public class 课程表2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] res = new int[numCourses];

        if (numCourses <= 0) {
            return res;
        }

        // 特判
        int pLen = prerequisites.length;
        if (pLen == 0) {
            return res;
        }

        int[] inDegrees = new int[numCourses];

        HashSet<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new HashSet<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            //入读+1
            inDegrees[prerequisites[i][0]]++;
            //把他加到临街链表里面
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        //找到一个入读为0的节点
        for (int i = 0; i < numCourses ; i++) {
            if(inDegrees[i] == 0){
                queue.add(i);
            }
        }

        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()){
            Integer top = queue.poll();
            list.add(top);
            for(int sucessor : adj[top]){
                inDegrees[sucessor]--;
                //判断是否达到入队条件即入读为0
                if(inDegrees[sucessor] == 0){
                    queue.add(sucessor);
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;

    }

}
