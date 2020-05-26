package com.example.leetcode3.copy1;

/**
 * @author yingru.ljw
 * @date 2020-03-02 22:48
 */
public class 存在重复元素 {

    /**
     * 基数排序
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length ==0){
            return false;
        }

        int max = nums[0];
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int min = nums[0];
        for (int num : nums) {
            min = Math.min(num, min);
        }

        int[] buckets = new int[max-min+1];

        for (int value : nums) {
            buckets[value - min]++;
        }

        for (int bucket : buckets) {
            if (bucket > 1) {
                return true;
            }
        }

        return false;

    }
}
