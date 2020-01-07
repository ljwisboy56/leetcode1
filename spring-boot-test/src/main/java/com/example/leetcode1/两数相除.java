package com.example.leetcode1;

/**
 * @author yingru.ljw
 * @date 2020-01-04 21:11
 */
public class 两数相除 {

    public static void main(String[] args) {
        int a = new 两数相除().divide(-2147483648,-1);
        System.out.println(a);

        System.out.println(Math.abs(-2147483648));
    }

    public int divide(int dividend, int divisor) {

        if(divisor == 0){
            return -1;
        }

        boolean res = dividend < 0 && divisor >0 || dividend >0 && divisor <0;

        int tmpDiv = Math.abs(dividend);
        int tmpDivisor = Math.abs(divisor);

        int count = -1;
        while (tmpDiv >= 0){
            for(int i = 1; i <= Math.abs(tmpDivisor);i++){
                tmpDiv--;
            }
            count++;
        }
        if(res){
            return -count;
        }else {
            return count;
        }
    }


}
