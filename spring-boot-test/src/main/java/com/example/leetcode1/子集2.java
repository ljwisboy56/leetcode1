package com.example.leetcode1;

import com.example.order.In;

import java.util.*;

/**
 * @author yingru.ljw
 * @date 2020-01-15 23:28
 */
public class 子集2 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        List<List<Integer>> allList = new 子集2().subsetsWithDup(nums);


    }

    HashSet<String> set = new HashSet<>();

    List<List<Integer>> allList = new ArrayList<>();

    List<Integer> list = new ArrayList<>();

    int[] x ;

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        x = new int[nums.length];

        doSub(0,nums);

        return allList;

    }

    private void doSub(int n, int[] nums) {

        if(n >=  nums.length){
            List<Integer> list = output(x,nums);
            if(list != null){
                allList.add(list);
            }
        }else {
            for (int i =0;i <=1;i++){
                x[n] = i;
                doSub(n+1,nums);
                x[n] = 0;
            }
        }
    }

    private ArrayList<Integer> output(int[] x,int[] nums) {

        String key = "";
        ArrayList<Integer> list = new ArrayList<>();
        for (int i =0; i < x.length;i++){
            if(x[i] == 1){

                list.add(nums[i]);
            }
        }

        Collections.sort(list);
        for(Integer integer : list){
            key+="-"+integer;
        }

        if(set.contains(key)){
            return null;
        }else {
            set.add(key);
            return list;
        }

    }


}
