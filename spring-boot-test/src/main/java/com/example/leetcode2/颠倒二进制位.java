package com.example.leetcode2;

/**
 * @author yingru.ljw
 * @date 2020-02-18 20:21
 */
public class 颠倒二进制位 {

    public static void main(String[] args) {

        System.out.println(new 颠倒二进制位());


    }

    public int reverseBits(int n) {

        int res =0;
        for (int i = 0,step = 1;i <=31;i--,step*=2){
          if((n & 1)==0){
              res += step;
          }
          n >>>=1;
        }
        return res;


    }

}
