package com.example.leetcode1.copy2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-18 15:01
 */
public class 第46题全排列 {

    //*****************解法1**************************************************************
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length ==0) return allList;
        dfs(0,nums);
        return allList;
    }

    private void dfs(int n, int[] nums) {
        if(n >= nums.length){
            List<Integer> list = new ArrayList<>();
            for(int tmp : nums){
                list.add(tmp);
            }
            allList.add(list);
            return;
        }else {
            for (int i = n; i < nums.length ; i++) {
                swap(nums,i,n);
                dfs(n+1,nums);
                swap(nums,i,n);
            }
        }
    }

    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

//*****************解法2**************************************************************
    boolean[] book;

    List<List<Integer>> allList = new ArrayList<>();

    public List<List<Integer>> permute2(int[] nums) {
        if(nums == null || nums.length ==0) return allList;
        book = new boolean[nums.length];
        Arrays.fill(book,false);
        dfs2(0,nums);
        return allList;
    }

    List<Integer> list = new ArrayList<>();
    private void dfs2(int n, int[] nums) {
        if(n >= nums.length){
            allList.add(new ArrayList<>(list));
            return;
        }else {
            for (int i = 0; i < nums.length; i++) {
                if(book[i]){
                    continue;
                }
                book[i] = true;
                list.add(nums[i]);
                dfs2(n+1,nums);
                list.remove(list.size()-1);
                book[i] = false;
            }
        }
    }

}
