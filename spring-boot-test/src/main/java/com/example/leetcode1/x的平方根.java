package com.example.leetcode1;

/**
 * @author yingru.ljw
 * @date 2020-01-09 17:00
 */
public class x的平方根 {

    public static void main(String[] args) {

        System.out.println("1");
        int res = new x的平方根().mySqrt(2147395600);
        System.out.println(res);

    }

    public int mySqrt(int x) {
        long res = 0;

        long nx = x;

        for (long i = 1;i <nx;i++){
            if(i * i <= nx){
                long tmp = i ;
                res = Math.max(tmp,res);
            }else {
                break;
            }
        }
        int rr = (int) res;
        return rr;
    }


}
