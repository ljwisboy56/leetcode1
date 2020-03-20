package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-19 11:36
 */
public class 第50题Pow {


    public double myPow(double x, int n) {
        double res = fastPow(x,n);
        return n > 0 ? res :1/res;
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
