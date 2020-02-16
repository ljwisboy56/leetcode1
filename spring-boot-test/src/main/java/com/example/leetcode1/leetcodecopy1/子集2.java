package com.example.leetcode1.leetcodecopy1;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-11 01:10
 */
public class 子集2 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2};
        List<List<Integer>> allList  = new 子集2().subsetsWithDup(arr);
        System.out.println(allList);
    }

    List<List<Integer>> allList = new ArrayList<>();

    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        doFind(0,nums,0);

        return allList;

    }

    private void doFind(int n, int[] nums,int level) {
        allList.add(new ArrayList<>(list));
        for (int i =n; i < nums.length;i++){
            if(i > n &&  nums[i] == nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            doFind(i+1,nums,level+1);
            list.remove(list.size()-1);
        }
    }

}
