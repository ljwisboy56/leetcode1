package com.example.leetcode1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 组合 {

    public static void main(String[] args) {

        List<List<Integer>> as = new 组合().combine2(4,2);
        System.out.println(as);


    }

    private List<List<Integer>> res = new ArrayList<>();

    List<Integer> list = new ArrayList<>();

    private void findCombinations(int n, int k, int begin, Stack<Integer> pre) {
        if (pre.size() == k) {
            // 够数了，就添加到结果集中
            res.add(new ArrayList<>(pre));
            return;
        }
        // 关键在于分析出 i 的上界
        for (int i = begin; i <= n; i++) {
            pre.add(i);
            findCombinations(n, k, i + 1, pre);
            pre.pop();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        // 特判
        if (n <= 0 || k <= 0 || n < k) {
            return res;
        }
        // 从 1 开始是题目的设定
        findCombinations(n, k, 1, new Stack<>());
        return res;
    }

    int[] x;
    public List<List<Integer>> combine2(int n, int k) {
        // 特判
        if (n <= 0 || k <= 0 || n < k) {
            return res;
        }

        int arr[] = new int[n];
        for(int i =1 ;i <= n ;i++){
            arr[i-1] = i;
        }

        x= new int[n];
        // 从 1 开始是题目的设定
        doFind(0,arr);
        return res;
    }

    private void doFind(int n, int[] arr) {

        if(n == arr.length){
            return;
        }else {
            for (int i =1;i >=0;i--){
                x[n] = i;
                if(constraint(x,n,arr)){
                    List<Integer> list = output(x,n,arr);
                    res.add(list);
                }else {
                    doFind(n+1,arr);
                }
                x[n] = 0;
            }
        }
    }

    private boolean constraint(int[] x,int n,int[] arr) {
        int count = 0;
        for (int i =0;i <= n ;i++){
            if(x[i] == 1){
                count++;
            }
        }
        return count == 2;
    }

    private ArrayList<Integer> output(int[] x,int n,int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0;i<= n;i++){
            if(x[i] == 1){
                list.add(arr[i]);
            }
        }
        return list;
    }


}

