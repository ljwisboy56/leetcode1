package com.example.leetcode1.copy2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-22 15:46
 */
public class 第90题子集2 {

    public static void main(String[] args) {
        List<List<Integer>> allList = new 第90题子集2().subsetsWithDup(new int[]{1, 2, 2});
        System.out.println(allList);

    }

    List<List<Integer>> allList = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return allList;
        }
        Arrays.sort(nums);
        dfs(0, nums);
        return allList;
    }

    private void dfs(int n, int[] nums) {
        if (n > nums.length) {
            return;
        } else {
            allList.add(new ArrayList<>(list));
            for (int i = n; i < nums.length; i++) {
                if (i > n && nums[i] == nums[i-1]) {
                    continue;
                }
                list.add(nums[i]);
                dfs(i + 1, nums);
                list.remove(list.size() - 1);
            }
        }

    }
}

