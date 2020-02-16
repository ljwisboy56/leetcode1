package com.example.leetcode1;


import java.util.*;

/**
 * @author yingru.ljw
 * @date 2020-01-07 23:52
 */
public class 第K个排列 {

    public static void main(String[] args) {
        String res = new 第K个排列().getPermutation(3,5);
        System.out.println(res);

        System.out.println(jieceng(4));

    }

    List<Long> allList = new ArrayList<>();


    public String getPermutation(int n, int k) {
        //先初始化一个数组
        char[] arr = new char[n];
        for(int i = 1; i <= n ; i++){
            arr[i-1] = String.valueOf(i).charAt(0);
        }

        doGeneratePermutation(0,arr);

        Collections.sort(allList);

        return String.valueOf(allList.get(k-1));
    }

    private void doGeneratePermutation(int n, char[] arr) {
        if(n >= arr.length){
            allList.add(Long.valueOf(new String(arr)));
        }else {
            for (int i = n; i<arr.length;i++){
                swap(arr,i,n);
                doGeneratePermutation(n+1,arr);
                swap(arr,i,n);
            }
        }
    }

    private static void swap(char[] arr,int i,int j){
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static int jieceng(int n){
        int tmp = 1;
        for(int i = 1; i <= n ;i++){
            tmp = tmp * i;
        }
        return tmp;
    }


}
