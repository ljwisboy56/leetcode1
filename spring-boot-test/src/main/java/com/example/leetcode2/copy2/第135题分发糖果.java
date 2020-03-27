package com.example.leetcode2.copy2;

import java.util.Arrays;

/**
 * @author yingru.ljw
 * @date 2020-03-26 00:54
 */
public class 第135题分发糖果 {


    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0){
            return 0;
        }

        int[] dpLeft = new int[ratings.length];
        Arrays.fill(dpLeft,1);
        dpLeft[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            dpLeft[i] = ratings[i] > ratings[i-1] ? dpLeft[i-1]+1:dpLeft[i];
        }

        int[] dpRight = new int[ratings.length];
        Arrays.fill(dpRight,1);
        dpRight[ratings.length-1] = 1;

        for (int i = ratings.length-2; i >= 0; i--) {
            dpRight[i] = ratings[i] > ratings[i+1] ? dpRight[i+1]+1:dpRight[i];
        }

        int sum =0;
        for(int i =0; i < ratings.length ;i++){
            //为什么选最大的，因为left本身就大于他左边的，right大于右边的，那么此时
            //如果left>right即可推出，left>right-1;
            sum += Math.max(dpLeft[i],dpRight[i]);
        }

        return sum;
    }


}
