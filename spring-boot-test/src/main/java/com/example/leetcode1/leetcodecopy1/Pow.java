package com.example.leetcode1.leetcodecopy1;

/**
 * @author yingru.ljw
 * @date 2020-02-06 13:05
 */
public class Pow {

    public static void main(String[] args) {
        double res = new Pow().myPow(2.10000,3);
        System.out.println(res);


    }


    public double myPow2(double x, int n) {

        if( x == 0){
            return 0;
        }
        //符号
        boolean flag = n > 0 ;

        double res = 1;
        for (int i =0; i < Math.abs(n);i++){
            res *= x;
        }

        if(flag){
            return res;
        }else {
            return 1/res;
        }

    }

    public double myPow(double x, int n) {

        double res = fastPow(x,n);

        return n > 0 ? res : 1/res;
    }

    private double fastPow(double x, int n) {

        if(n == 0){
            return 1.0;
        }

        double res = fastPow(x,n/2);
        if(n % 2 == 0){
            return res * res;
        }else {
            return res * res * x;
        }


    }
}
