package com.example.leetcode1.copy1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-05 12:14
 */
public class 全排列 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        List<List<Integer>> allList = new 全排列().permute(arr);
        System.out.println(allList);


    }

    List<List<Integer>> allList = new ArrayList<>();

    private HashSet<Integer> set = new HashSet<>();

    ArrayList<Integer> list = new ArrayList<>();


    public List<List<Integer>> permute(int[] nums) {

        if(nums == null || nums.length ==0){
            return allList;
        }

        Arrays.sort(nums);

        this.doPermuteUnique(0,nums);

        return allList;
    }

    private void doPermute(int n, int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(n >=nums.length){
            for (int tmp : nums){
                list.add(tmp);
            }
            allList.add(list);
        }else {
            for (int i =n;i < nums.length;i++){
                swap(nums,i,n);
                doPermute(n+1,nums);
                swap(nums,i,n);
            }
        }
    }

    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 目前来看这种全排列是有序的，比交换那个要好
     * @param n
     * @param nums
     */
    private void doPermuteUnique(int n, int[] nums) {
        if(n >= nums.length){
            allList.add(new ArrayList<>(list));
        }else{
            //这个表示的是每层的数据
            for (int i =0; i < nums.length;i++){
                if(!set.contains(nums[i])){
                    list.add(nums[i]);
                    set.add(nums[i]);
                    doPermuteUnique(n+1,nums);
                    list.remove(list.size()-1);
                    set.remove(nums[i]);
                }
            }
        }
    }

}
