package com.example.leetcode1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-01-11 21:01
 */
public class 子集 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        List<List<Integer>> res = new 子集().subsets(arr);
        System.out.println(res);
    }

    List<List<Integer>> res = new ArrayList<>();

    int[] x;
    public List<List<Integer>> subsets(int[] arr) {
        // 特判
        if(arr == null || arr.length == 0){
            return res;
        }

        x= new int[arr.length];
        doFind(0,arr);
        return res;
    }

    private void doFind(int n, int[] arr) {

        if(n >= arr.length){
            List<Integer> list = output(x,n,arr);
            res.add(list);
            return;
        }else {
            for (int i =1;i >=0;i--){
                x[n] = i;
                doFind(n+1,arr);
                x[n] = 0;
            }
        }
    }

    private ArrayList<Integer> output(int[] x,int n,int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0;i< n;i++){
            if(x[i] == 1){
                list.add(arr[i]);
            }
        }
        return list;
    }


}
