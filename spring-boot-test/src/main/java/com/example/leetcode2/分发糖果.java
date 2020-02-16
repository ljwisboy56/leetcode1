package com.example.leetcode2;

import java.util.Arrays;

/**
 * @author yingru.ljw
 * @date 2020-02-15 17:49
 */
public class 分发糖果 {


    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0){
            return 0;
        }

        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];

        //给每个人都先分配一个糖果
        Arrays.fill(left,1);;
        Arrays.fill(right,1);;

        for (int i = 1; i < ratings.length;i++){
            if(ratings[i] > ratings[i-1]){
                left[i] = left[i-1] + 1;
            }
        }

        for (int i = ratings.length-2; i >= 0;i--){
            if(ratings[i] > ratings[i+1]){
                right[i] = right[i+1] + 1;
            }
        }

        int sum = 0;
        for (int i = 0;i < ratings.length;i++){
            sum += Math.max(left[i],right[i]);
        }

        return sum;

    }


}
