package com.example.leetcode1;

/**
 * @author yingru.ljw
 * @date 2020-01-06 23:18
 */
public class PowFunction {

    public static void main(String[] args) {

        double res= new PowFunction().doPow(2.10000,3);
        System.out.println(res);

    }

    public double myPow(double x, int n) {
        if(x == 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }else if(n < 0){
            return 1/doPow(x,n);
        }else {
            return doPow(x,n);
        }
    }

    private double doPow(double x, int n) {
        double tmp = 1.0;

        int fn = Math.abs(n);

        for (int i=0;i<fn;i++){
            tmp *= x;
        }

        return tmp;
    }

    /**
     * 快速幂法
     *
     * @param x
     * @param n
     * @return
     */
    private double fastPow(double x, long n) {

        if(n == 0){
            return 1.0;
        }

        double res = fastPow(x,n/2);
        if(n % 2 ==0){
            return res * res;
        }else {
            return res * res * x;
        }

    }
}
