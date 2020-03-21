package com.example.leetcode1.copy2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-21 18:25
 */
public class 第78题子集 {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> allList = new 第78题子集().subsets(arr);
        System.out.println(allList);

    }

    /**
     * 输入: nums = [1,2,3]
     * 输出:
     * [
     *   [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     */
    List<List<Integer>> allList = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        if(nums == null || nums.length == 0){
            return allList;
        }

        dfs(0,nums);
        return allList;
    }

    private void dfs(int n, int[] nums) {

        if(n > nums.length){
            return;
        }else {
            allList.add(new ArrayList<>(list));
            for (int i = n; i < nums.length ; i++) {
                list.add(nums[i]);
                dfs(i+1,nums);
                list.remove(list.size()-1);
            }
        }
    }


}
