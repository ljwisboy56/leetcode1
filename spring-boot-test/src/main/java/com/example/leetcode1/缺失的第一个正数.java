package com.example.leetcode1;

/**
 * @author yingru.ljw
 * @date 2020-01-06 16:35
 */
public class 缺失的第一个正数 {

    /**
     * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
     *
     * 示例 1:
     *
     * 示例 2:
     *
     * 输入: [3,4,-1,1] = [3,4,MAX,1]=[-3,4,MAX,-1]
     * 输出: 2
     * 示例 3:
     *
     * 输入: [7,8,9,11,12]
     * 输出: 1
     *
     * 思路1：
     * 遍历一次数组把大于等于1的和小于数组大小的值放到原数组对应位置，
     * 然后再遍历一次数组查当前下标是否和值对应，如果不对应那这个下标就是答案，
     * 否则遍历完都没出现那么答案就是数组长度加1。
     *
     * 思路2：
     * 第一遍把所有负数换成INT_MAX。
     * 第二遍，将出现的数的绝对值对应的位置的数置为负数。
     * 第三遍，不是负数就输出位置。
     *
     */
    public int firstMissingPositive(int[] nums) {
        //将所有负数置位intmax目的是排除掉所有的负数和0
        for(int i = 0; i < nums.length;i++){
            if(nums[i] <= 0){
                nums[i] = Integer.MAX_VALUE;
            }
        }

        //标记出位图中哪些数是有值的
        for(int i =0; i < nums.length;i++){
            if(Math.abs(nums[i]) - 1 < nums.length && nums[Math.abs(nums[i])] > 0){
                //标识这个位置被占用了，位图的思想
                nums[Math.abs(nums[i])] *= -1;
            }
        }
        //找出第一个没有值的数组坐标索引，因为索引和真正的正数之间差了1，所以最后加1
        for (int i =0; i < nums.length;i++){
            if(nums[i] >= 0){
                return i +1;
            }
        }

        return nums.length+1;
    }

}
