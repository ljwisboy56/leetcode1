package com.example.leetcode3.copy2;

import java.util.*;

/**
 * @author yingru.ljw
 * @date 2020-03-30 15:21
 */
public class 第210题课程表2 {

    /**
     * 输入: 2, [[1,0]]
     * 输出: [0,1]
     * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if (numCourses <= 0) {
            return null;
        }

        // 特判
        int pLen = prerequisites.length;
        if (pLen == 0) {
            return null;
        }

        //临接链表
        HashMap<Integer, HashSet<Integer>> adj = new HashMap<>();
        //入读数组
        int[] indegrees = new int[numCourses];
        for (int[] pair : prerequisites) {
            indegrees[pair[0]]++;
        }

        for(int[] arr : prerequisites){
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

        //找出所有入读为0的节点
        Queue<Integer> queue =new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(indegrees[i] == 0){
                queue.add(i);
            }
        }

        int count = 0;
        List<Integer> results = new ArrayList<>();
        while (!queue.isEmpty()) {
            int course = queue.poll();
            results.add(course);
            count++;
            for (Integer c : adj.get(course)) {
                indegrees[c]--;
                if (indegrees[c] == 0) {
                    queue.add(c);
                }
            }
        }

        // 判断是否有拓扑排序
        if (count != numCourses) {
            return new int[0];
        }

        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = results.get(i);
        }
        return res;

    }

}
