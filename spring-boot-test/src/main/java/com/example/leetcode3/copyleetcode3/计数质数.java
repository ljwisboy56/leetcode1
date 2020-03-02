package com.example.leetcode3.copyleetcode3;

import sun.jvm.hotspot.debugger.Page;

/**
 * @author yingru.ljw
 * @date 2020-03-02 16:28
 */
public class 计数质数 {

    public static void main(String[] args) {
        int res = new 计数质数().countPrimes(10);
//        System.out.println(res);


    }


    public int countPrimes(int n) {

        if(n == 0 || n == 1 || n == 2){
            return 0;
        }

        int count = 0;

        for (int i = 3; i < n; i+=2) {
            if(zhishu(i)){
                count++;
            }
        }

        return count+1;

    }

    private boolean zhishu(int n){
        if (n <= 3) {
            return n > 1;
        }

        int k = (int) Math.sqrt(n);

        for(int i = 2; i <= k; i++){
            if (n % i == 0) {
                return false;
            }
        }
        return true;

    }

}
