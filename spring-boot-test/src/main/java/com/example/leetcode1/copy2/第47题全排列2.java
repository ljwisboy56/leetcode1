package com.example.leetcode1.copy2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-18 17:44
 */
public class 第47题全排列2 {


    boolean[] book;

    List<List<Integer>> allList = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length ==0) {
            return allList;
        }
        book = new boolean[nums.length];
        Arrays.fill(book,false);
        Arrays.sort(nums);
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
                if(i > 0 && nums[i] == nums[i-1] && book[i-1]){
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
