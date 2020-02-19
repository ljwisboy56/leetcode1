package com.example.leetcode2;

/**
 * @author yingru.ljw
 * @date 2020-02-18 22:29
 */
public class 位1的个数 {

    public static void main(String[] args) {

        System.out.println(new 位1的个数().hammingWeight(3));

    }


    public int hammingWeight(int n) {

        int count =0;
        while (n != 0){
            if((n & 1) == 1){
                count++;
            }
            n>>>=1;
        }
        return count;

    }

}
