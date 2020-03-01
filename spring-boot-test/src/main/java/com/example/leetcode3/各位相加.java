package com.example.leetcode3;

/**
 * @author yingru.ljw
 * @date 2020-02-29 17:00
 */
public class 各位相加 {

    public static void main(String[] args) {
        System.out.println(new 各位相加().addDigits(38));
    }

    public int addDigits(int num) {

        int len = (num + "").length();

        if(len == 1){
            return num;
        }

        int sum = 0;
        for (int i = 0,step = 1; i < len; i++,step *= 10) {
            sum += num / step % 10;
        }

        return addDigits(sum);
    }

}
