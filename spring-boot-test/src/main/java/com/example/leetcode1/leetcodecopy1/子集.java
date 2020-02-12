package com.example.leetcode1.leetcodecopy1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-09 14:18
 */
public class 子集 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> allList = new 子集().subsets(nums);
        System.out.println(allList);
    }

    List<List<Integer>> allList = new ArrayList<>();

    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        this.doFind2(0, nums);

        return allList;

    }

    private void doFind2(int n, int[] nums) {
        allList.add(new ArrayList<>(list));
        for (int i = n; i < nums.length; i++) {
            list.add(nums[i]);
            doFind2(i + 1, nums);
            list.remove(list.size() - 1);
        }
    }


    private void doFind(int n, int[] nums) {

        if (n >= nums.length) {
            allList.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i <= 1; i++) {
                if (i == 1) {
                    list.add(nums[n]);
                }
                doFind(n + 1, nums);
                if (i == 1) {
                    list.remove(list.size() - 1);
                }
            }
        }


    }

}
