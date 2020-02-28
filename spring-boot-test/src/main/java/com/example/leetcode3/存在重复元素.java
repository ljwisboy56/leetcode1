package com.example.leetcode3;

/**
 * @author yingru.ljw
 * @date 2020-02-27 12:49
 */
public class 存在重复元素 {

    public static void main(String[] args) {

        boolean res = new 存在重复元素().containsDuplicate(new int[]{1,2,3,1});
        System.out.println(res);

    }

    public boolean containsDuplicate(int[] nums) {

        if(nums == null || nums.length ==0){
            return true;
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
