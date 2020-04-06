package com.example.leetcode3;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yingru.ljw
 * @date 2020-02-28 13:49
 */
public class 滑动窗口最大值 {


    public static void main(String[] args) {
        int[] res = new 滑动窗口最大值().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
        System.out.println(res);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) {
            return nums;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2-o1);
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int i = 0; i < k; i++) {
            priorityQueue.add(nums[i]);
        }

        int[] res = new int[nums.length -k +1];
        for (int i = 0; i < nums.length; i++) {
            res[i] = priorityQueue.peek();
            //下面两步就是维护一个窗口
            //移除前面的
            priorityQueue.remove(nums[i]);
            if(i + k < nums.length){
                //加上后面的
                priorityQueue.add(nums[i+k]);
            }
        }
        return res;

    }

}
