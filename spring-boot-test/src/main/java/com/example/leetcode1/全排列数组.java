package com.example.leetcode1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-01-06 19:46
 */
public class 全排列数组 {


    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        doFind(0, nums);

        return lists;

    }

    private void doFind(int n, int[] nums) {

        if (n >= nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int tmp : nums) {
                list.add(tmp);
            }
            lists.add(list);
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
