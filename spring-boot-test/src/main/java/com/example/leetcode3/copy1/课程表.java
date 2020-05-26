package com.example.leetcode3.copy1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yingru.ljw
 * @date 2020-03-02 18:37
 */
public class 课程表 {

    public static void main(String[] args) {
        boolean res= new 课程表().canFinish(2,new int[][]{{1,0}});
        System.out.println(res);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (numCourses <= 0) {
            return false;
        }

        // 特判
        int pLen = prerequisites.length;
        if (pLen == 0) {
            return true;
        }

        int[] indegrees = new int[numCourses];

        //临街链表
        HashMap<Integer, HashSet<Integer>> adj = new HashMap<>();
        for(int[] arr : prerequisites){
            indegrees[arr[0]]++;
            if(!adj.containsKey(arr[1])){
                HashSet<Integer> set = new HashSet<>();
                set.add(arr[0]);
                adj.put(arr[1],set);
            }else {
                HashSet<Integer> set = adj.get(arr[1]);
                set.add(arr[0]);
                adj.put(arr[1],set);
            }
        }

        //图的BFS遍历
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(indegrees[i] == 0){
                queue.add(i);
            }
        }

        int level = 0;
        while (!queue.isEmpty()){
            level++;
            int top = queue.poll();
            HashSet<Integer> set = adj.get(top);
            if(set == null){
                continue;
            }
            for (int tmp : set) {
                indegrees[tmp]--;
                if(indegrees[tmp] == 0){
                    queue.add(tmp);
                }
            }
        }

        return level == numCourses;

    }


}
