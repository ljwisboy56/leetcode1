package com.example.leetcode3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yingru.ljw
 * @date 2020-02-29 14:12
 */
public class 会议室2 {

    class Interval{
        int start ;
        int end ;
        Interval(int start,int end){
            this.start = start;
            this.end = end;
        }
    }

    public int minMeetingRooms(int[][] intervals) {

        Interval[] intervals1 = new Interval[intervals.length];

        int i = 0;
        for(int[] arr : intervals){
            Interval interval = new Interval(arr[0],arr[1]);
            intervals1[i] = interval;
            i++;
        }

        return minMeetingRooms2(intervals1);

    }

    /**
     * 按照会议开始时间进行排序
     * 创建一个小顶堆，堆顶填第一个会议的结束时间
     * 依次遍历每个会议，检查堆顶的会议室是否空闲（判断条件：每个会议的开始时间 是否大于 堆顶会议的结束时间）：
     * a.如果空闲，就拿掉堆顶的现有会议，加入新的会议
     * b.如果不空闲，就新开会议室，即insert入新的会议
     * 返回堆得元素个数，即需要的会议室数量
     *
     */
        public int minMeetingRooms2 (Interval[]intervals){

            if (intervals.length == 0) {
                return 0;
            }

            // Min heap
            PriorityQueue<Integer> allocator = new PriorityQueue<>(
                            intervals.length,
                            Comparator.comparingInt(a -> a));

            // Sort the intervals by start time
            Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));

            allocator.add(intervals[0].end);

            for (int i = 1; i < intervals.length; i++) {

                if (intervals[i].start >= allocator.peek()) {
                    allocator.poll();
                }

                allocator.add(intervals[i].end);
            }

            return allocator.size();
        }


}
