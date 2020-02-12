package com.example.leetcode1.leetcodecopy1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-07 13:18
 */
public class 第k个排列 {

    public static void main(String[] args) {
        String res = new 第k个排列().getPermutation(8,3656);
        int r = new 第k个排列().countJieCeng(7);
        System.out.println(res);

    }

    int count = 0;

    List<Integer> list = new ArrayList<>();

    String res = "";

    int k =0;

    HashSet<Integer> set = new HashSet<>();

    int[] dp;

    public String getPermutation(int n, int k) {

        this.k = k;

        int[] arr = new int[n];

        dp = new int[n];

        dp[0] = 1;

        //先初始化数组
        for (int i =1; i <=n;i++){
            arr[i-1] = i;
            dp[i-1] = countJieCeng(i-1);
        }


        doGetPermutation(0,arr);

        return res;

    }

    private boolean doGetPermutation(int n, int[] arr) {

        if(n >= arr.length){
            count++;
            if(count == k){
                StringBuilder stringBuilder = new StringBuilder();
                for (int tmp : list){
                    stringBuilder.append(tmp);
                }
                res = stringBuilder.toString();
                return false;
            }
        }else {
            for (int i =0; i < arr.length;i++){
                if(!set.contains(arr[i])){
                    set.add(arr[i]);
                    list.add(arr[i]);
                    if(constraint(arr,n) && doGetPermutation(n+1,arr)){
                        return true ;
                    }
                    list.remove(list.size()-1);
                    set.remove(arr[i]);
                }
            }
        }

        return false;
    }

    private boolean constraint(int[] arr, int n) {
//        int tmp = countJieCeng(arr.length-1-n);
        int tmp = dp[arr.length-1-n];
        if(count + tmp< k){
            count += tmp;
            return false;
        }
        return true;
    }

    private int countJieCeng(int n){
        int res = 1;
        for (int i = 1; i <= n;i++){
            res *= i;
        }
        return res;
    }

}
