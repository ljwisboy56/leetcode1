package com.example.leetcode3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-27 12:37
 */
public class 组合总和3 {

    public static void main(String[] args) {

        List<List<Integer>> allList = new 组合总和3().combinationSum3(2,9);
        System.out.println(allList);


    }

    int target = 0;

    int size = 0;

    List<List<Integer>> allList = new ArrayList<>();

    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {

        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = i+1;
        }

        this.target  = n;

        this.size = k;

        dfs(0,0,arr);

        return allList;


    }

    private void dfs(int n, int sum,int[] arr) {

        if(n >= arr.length || list.size() == size){
            if(sum == target && list.size() == size){
                allList.add(new ArrayList<>(list));
            }
            return;
        }else {
            for (int i = n; i < arr.length; i++) {
                sum += arr[i];
                list.add(arr[i]);
                if(sum > target){
                    sum -= arr[i];
                    list.remove(list.size()-1);
                    break;
                }
                dfs(i+1,sum,arr);
                sum -= arr[i];
                list.remove(list.size()-1);
            }
        }
    }

}
