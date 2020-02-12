package com.example.leetcode1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-01-05 21:45
 */
public class 组合总和 {

    int target ;

    List<List<Integer>> lists = new ArrayList<>();

    ArrayList<Integer> list = new ArrayList<>();


    public static void main(String[] args) {


        int[] arr = new int[]{7,3,2};

        List<List<Integer>> lists = new 组合总和().combinationSum(arr,18);
        System.out.println(lists.size());

        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(1);


        List<Integer> l2 = new ArrayList<>();
        l1.add(2);
        l1.add(1);


        System.out.println(l1.containsAll(l2));

    }

    /**
     *
     * 输入: candidates = [2,3,6,7], target = 7,
     * 所求解集为:
     * [
     *   [7],
     *   [2,2,3]
     * ]
     *
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        this.target = target;

        doFind(0,candidates);

        return lists;


    }

    private void doFind(int n, int[] candidates) {

        if(n >= target || sum(list) == target){
            lists.add(new ArrayList<>(list));
            return;
        }else {
            for(int i = n;i < candidates.length ;i++){
                list.add(candidates[i]);
                if(constraint(list)){
                    doFind(i,candidates);
                }
                list.remove(list.size()-1);
            }
        }
    }

    private boolean constraint(ArrayList<Integer> list) {
        return sum(list) <= target;
    }

    private int sum(List<Integer> list) {
        int sum =0;
        for (Integer integer : list){
            sum += integer;
        }
        return sum;
    }


}
