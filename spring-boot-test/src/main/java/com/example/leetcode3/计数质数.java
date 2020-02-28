package com.example.leetcode3;

/**
 * @author yingru.ljw
 * @date 2020-02-26 13:14
 */
public class 计数质数 {

    public static void main(String[] args) {

        int res = new 计数质数().countPrimes(2);
        System.out.println(res);

    }


    public int countPrimes(int n) {

        int count = 0;

        for (int i = 3; i < n; i+=2) {
            if(zhishu(i)){
                count++;
            }
        }

        if(n == 0 || n == 1){
            return 0;
        }

        if(n == 2){
            return 0;
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
