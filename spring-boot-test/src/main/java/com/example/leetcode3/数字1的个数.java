package com.example.leetcode3;

/**
 * @author yingru.ljw
 * @date 2020-02-28 11:40
 */
public class 数字1的个数 {

    public static void main(String[] args) {
        int res = new 数字1的个数().countDigitOne(13);
        System.out.println(res);


    }

    public int countDigitOne(int n) {

        int count = 0;
        for (int i = 1 ; i <=n ; i++) {
            char[] strs = String.valueOf(i).toCharArray();
            for (char tmp : strs){
                if(tmp == '1'){
                    count++;
                }
            }
        }
        return count;

    }
}
