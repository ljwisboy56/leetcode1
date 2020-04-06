package com.example.leetcode2.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-29 02:13
 */
public class 第172题阶乘后的零 {

    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0){
            n /= 5;
            count += n;
        }
        return count;
    }

}
