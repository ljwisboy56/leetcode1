package com.example.leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-01-06 19:57
 */
public class 不重复全排列 {


    HashSet<String> set = new HashSet<>();

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);

        doFind(0, nums);

        return lists;

    }

    private void doFind(int n, int[] nums) {

        if (n >= nums.length) {
            String key = "";
            List<Integer> list = new ArrayList<>();
            for (int tmp : nums) {
                key += "-" + tmp;
                list.add(tmp);
            }

            if(!set.contains(key)){
                set.add(key);
                lists.add(list);
            }

        } else {
            for (int i = n; i < nums.length; i++) {
                swap(nums, i, n);
                doFind(n + 1, nums);
                swap(nums, i, n);
            }
        }
    }


    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
