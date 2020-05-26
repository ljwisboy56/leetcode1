package com.example.leetcode1.copy1;

/**
 * @author yingru.ljw
 * @date 2020-02-08 01:21
 */
public class x的平方根 {

    public static void main(String[] args) {
        int res = new x的平方根().mySqrt(8);
        System.out.println(res);


    }

    public int mySqrt(int x) {

        long res = 0;

        long nx = x;

        for (long i =1;i <= nx;i++){
            if(i * i <= nx){
                res = Math.max(i,res);
            }else {
                break;
            }
        }

        return (int) res;
    }

}
