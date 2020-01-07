package com.example.leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-01-05 23:29
 */
public class 组合总和2 {

    HashSet<String> set = new HashSet<>();

//    public static void main(String[] args) {
//        int[] arr = new int[]{10,1,2,7,6,1,5};
//        List<List<Integer>> res = new 组合总和2().combinationSum2(arr,8);
//        System.out.println(res.size());
//
//    }

    static int[] x = null;

    List<List<Integer>> allList = new ArrayList<>();


    int target =0;
    /**
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的每个数字在每个组合中只能使用一次。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum-ii
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.target = target;
        x = new int[candidates.length];
        doFind(0,candidates);
        return allList;
    }

    private void doFind(int n, int[] candidates) {

        if(n >= candidates.length){
            if(sum(x,candidates) == target){
                List<Integer> tl = output(x,candidates);
                if(tl != null){
                    allList.add(tl);
                }
            }
        }else {
            for (int i =0;i <= 1;i++){
                x[n] = i;
                if(constraint(x,candidates)){
                    doFind(n+1,candidates);
                }
                x[n] = 0;
            }
        }

    }

    private List<Integer> output(int[] x,int[] candidates) {
        String key = "";
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < x.length;i++){
            if(x[i] == 1){
                key += "-" + candidates[i];
            }
        }
        if(!set.contains(key)){
            set.add(key);
        }else {
            return null;
        }

        for (int i = 0;i < x.length;i++){
            if(x[i] == 1){
                list.add(candidates[i]);
            }
        }
        return list;

    }

    private boolean constraint(int[] x,int[] candidates) {
        String key = "";
        int sum =0;
        for (int i = 0;i < x.length;i++){
            if(x[i] == 1){
                sum += candidates[i];
                key += "-" + candidates[i];
            }
        }


        return sum <= target;
    }

    private int sum(int[] x,int[] candidates) {
        int sum =0;
        for (int i = 0;i < x.length;i++){
            if(x[i] == 1){
                sum += candidates[i];
            }
        }
        return sum;
    }
}
