package com.example.leetcode2.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-29 23:22
 */
public class 第191题位1的个数 {


    public int hammingWeight(int n) {

        int count =0;
        while (n != 0){
            if((n & 1) == 1){
                count++;
            }
            n >>>= 1;
        }
        return count;

    }

}
