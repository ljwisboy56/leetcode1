package com.example.leetcode2.copyleetcode2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-23 12:51
 */
public class 最大间距 {

    public int maximumGap(int[] nums) {

        if(nums.length < 2){
            return 0;
        }

        this.radaxSort(nums);

        return this.find(nums);


    }

    private int find(int[] nums) {

        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i] - nums[i-1],max);
        }
        return max;

    }

    private void radaxSort(int[] nums) {

        int[][] bucket = new int[10][nums.length];

        int[] bucketSzie = new int[10];

        int max = nums[0];
        for (int tmp : nums) {
            max = Math.max(max,tmp);
        }

        int len = (max + "").length();

        for (int j = 0,n = 1; j < len; j++,n *=10) {
            for (int value : nums) {
                int index = value / n % 10;
                bucket[index][bucketSzie[index]++] = value;
            }
            int pos = 0;
            for (int i = 0; i < bucketSzie.length; i++) {
                if(bucketSzie[i] != 0){
                    for (int k = 0; k < bucketSzie[i] ; k++) {
                        nums[pos++] = bucket[i][k];
                    }
                    bucketSzie[i] = 0;
                }
            }
        }

    }

}
