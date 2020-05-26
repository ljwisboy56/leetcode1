package com.example.leetcode1.copy1;

/**
 * @author yingru.ljw
 * @date 2020-02-02 18:36
 */
public class 两数相除 {

    public static void main(String[] args) {
        int res = new 两数相除().divide(-2147483648,-1);
        System.out.println(res);


    }


    public int divide(int dividend, int divisor) {

        //使用亦或来确定符号
        boolean flag = (dividend ^ divisor) >=0;

        long rdd = dividend >= 0 ? -dividend : dividend;

        long rdr = divisor >= 0 ? -divisor : divisor;

        int count =0;
        while (rdd < 0){
            long copyRdd = rdd;
            if(copyRdd - rdr <= 0){
                count++;
                rdd -= rdr;
            }else {
                break;
            }
        }

        return flag?count:-count;

    }

}
