package com.example.leetcode3.copy1;

/**
 * @author yingru.ljw
 * @date 2020-03-02 21:03
 */
public class 长度最小的子数组 {

    /**
     * 输入: s = 7, nums = [2,3,1,2,4,3]
     * 输出: 2
     * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
     */
    public int minSubArrayLen(int s, int[] nums) {

        int left = 0;
        int right = 0;

        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (right <= nums.length-1){
            if(sum + nums[right] < s){
                sum += nums[right];
                right++;
            }else {
                min = Math.min(min,right-left+1);
                sum -= nums[left];
                left++;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

}
