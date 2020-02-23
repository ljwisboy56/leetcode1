package com.example.leetcode2.copyleetcode2;

/**
 * @author yingru.ljw
 * @date 2020-02-22 16:06
 */
public class 乘积最大子序列 {

    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        System.out.println(new 乘积最大子序列().maxProduct(arr));


    }

    /**
     * dp[i] = if(nums(i) < 0)
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int[] plus = new int[nums.length];

        int[] minus = new int[nums.length];

        plus[0] = nums[0];

        minus[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] >= 0){
                //因为越大的树成一个更大的肯定是更大的
                plus[i] = Math.max(Math.max(plus[i-1],minus[i-1]) * nums[i],nums[i]);
                minus[i] = Math.min(Math.min(plus[i-1],minus[i-1]) * nums[i],nums[i]);
            }else {
                plus[i] = Math.max(Math.min(plus[i-1],minus[i-1]) * nums[i],nums[i]);
                minus[i] = Math.min(Math.max(plus[i-1],minus[i-1]) * nums[i],nums[i]);
            }
        }

        int max = plus[0];
        for (int tmp : plus){
            max = Math.max(tmp,max);
        }
        return max;


    }


}
