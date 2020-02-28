package com.example.leetcode3;

/**
 * @author yingru.ljw
 * @date 2020-02-26 21:01
 */
public class 长度最小的子数组 {


    public static void main(String[] args) {
        int res = new 长度最小的子数组().minSubArrayLen(3,new int[]{1,1});
        System.out.println(res);
    }

    public int minSubArrayLen(int s, int[] nums) {

        if(nums == null || nums.length ==0){
            return 0;
        }


        int p1 = 0;
        int p2 = 0;

        int min = Integer.MAX_VALUE;

        int sum = nums[0];

        while (true){
            if(sum < s){
                p2++;
                if(p2 > nums.length-1){
                    break;
                }
                sum += nums[p2];
            }else {
                min =Math.min(min,p2 - p1 +1 );
                sum -= nums[p1];
                p1++;
            }
        }

        if(min == Integer.MAX_VALUE){
            return 0;
        }else {
            return min;
        }

    }

}
