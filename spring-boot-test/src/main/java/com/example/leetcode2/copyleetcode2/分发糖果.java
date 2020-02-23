package com.example.leetcode2.copyleetcode2;

import java.util.Arrays;

/**
 * @author yingru.ljw
 * @date 2020-02-21 20:59
 */
public class 分发糖果 {

    public static void main(String[] args) {
        int res = new 分发糖果().candy(new int[]{1,0,2});
        System.out.println(res);


    }

    /**
     *
     * dp（i） = if(r(i) > r(i-1) dp(i-1) +1;
     * 2趟遍历
     * 从左边遍历一次，找出应该发多少糖果
     * 再从右边遍历一次，找出应该发多少糖果
     * 最后取出每个位置上最多的那个
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {

        if(ratings == null || ratings.length == 0){
            return 0;
        }
        int[] rightDp = new int[ratings.length];
        int[] leftDp = new int[ratings.length];

        //没必要
//
//        //给每个人都先分配一个糖果
//        Arrays.fill(leftDp,1);;
//        Arrays.fill(rightDp,1);;


        leftDp[0] = 1;

        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1]){
                leftDp[i] = leftDp[i-1] + 1;
            }else {
                leftDp[i] = 1;
            }

        }



        rightDp[ratings.length-1] = 1;

        for (int i = ratings.length-2; i >=0; i--) {
            if(ratings[i] > ratings[i+1]){
                rightDp[i] = rightDp[i+1] + 1;
            }else {
                rightDp[i] = 1;
            }
        }

        int max = 0;
        for (int i = 0; i < ratings.length; i++) {
            max += Math.max(leftDp[i],rightDp[i]);
        }
        return max;

    }
}
