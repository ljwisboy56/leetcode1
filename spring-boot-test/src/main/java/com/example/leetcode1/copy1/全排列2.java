package com.example.leetcode1.copy1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-05 12:22
 */
public class 全排列2 {


    public static void main(String[] args) {
        int[] arr =new int[]{1,1,2,3};
        List<List<Integer>> allList = new 全排列2().permuteUnique(arr);
        System.out.println(allList);


    }

    private List<List<Integer>> allList = new ArrayList<>();

    private HashSet<Integer> set = new HashSet<>();

    ArrayList<Integer> list = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        if(nums == null || nums.length ==0){
            return allList;
        }

        Arrays.sort(nums);

        this.doPermuteUnique(0,nums);

        return allList;

    }

    //具体就是用全排列结合hash表来做
    private void doPermuteUnique(int n, int[] nums) {
        if(n >= nums.length){
            allList.add(new ArrayList<>(list));
        }else{
            //这个表示的是每层的数据
            for (int i =0; i < nums.length;i++){
                if(!set.contains(i)){
                    if(i > 0 && nums[i] == nums[i-1] && !set.contains(i-1)){
                        continue;
                    }
                    list.add(nums[i]);
                    set.add(i);
                    doPermuteUnique(n+1,nums);
                    list.remove(list.size()-1);
                    set.remove(i);
                }

            }
        }
    }
}
