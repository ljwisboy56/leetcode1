package com.example.leetcode1.copy2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-19 22:34
 */
public class 第60题第k个排列 {

    public static void main(String[] args) {
        System.out.println(new 第60题第k个排列().getPermutation(3,3));


    }
    int count = 0;
    List<Integer> list = new ArrayList<>();
    String res = "";
    int k =0;
    HashSet<Integer> set = new HashSet<>();
    public String getPermutation(int n, int k) {

        this.k = k;
        int[] arr = new int[n];
        //先初始化数组
        for (int i =1; i <=n;i++){
            arr[i-1] = i;
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
            for (int value : arr) {
                if (!set.contains(value)) {
                    int tmp = countJieCeng(arr.length - 1 - n);
                    if (count + tmp < k) {
                        count += tmp;
                        continue;
                    }
                    set.add(value);
                    list.add(value);
                    if (doGetPermutation(n + 1, arr)) {
                        return true;
                    }
                    list.remove(list.size() - 1);
                    set.remove(value);
                }
            }
        }

        return false;
    }

    private int countJieCeng(int n){
        int res = 1;
        for (int i = 1; i <= n;i++){
            res *= i;
        }
        return res;
    }

}
