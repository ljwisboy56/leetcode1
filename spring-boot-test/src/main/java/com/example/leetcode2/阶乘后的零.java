package com.example.leetcode2;

/**
 * @author yingru.ljw
 * @date 2020-02-18 13:09
 */
public class 阶乘后的零 {


    public static void main(String[] args) {
        int res = new 阶乘后的零().trailingZeroes(13);
        System.out.println(res);


    }

    public int trailingZeroes(int n) {
        long res = jieCeng(n);

        int count = 0;

        String str = res + "";

        for (int i = str.length()-1;i >=0;i--){
            if(str.charAt(i) != '0'){
                break;
            }
            count++;
        }


        return count;

    }

    private long jieCeng(int n){
        if(n == 0){
            return 1;
        }

        long res = 1;
        while (n > 0){
            res *= n;
            n--;
        }

        return res;
    }
}
