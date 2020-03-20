package com.example.leetcode1.copy2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-04 23:22
 */
public class 四数之和 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> allList = new ArrayList<>();
        if(nums == null || nums.length==0){
            return allList;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int newTarget = target -nums[i];
            int[] tmpNums = Arrays.copyOfRange(nums,i+1,nums.length);
            threeSum(tmpNums,newTarget,i);
        }
        return allList;
    }

    public List<List<Integer>> threeSum(int[] nums,int real,int cur) {
        List<List<Integer>> allList = new ArrayList<>();
        for (int i = 0; i < nums.length ; i++) {
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int newTarget = real - nums[i];
            int left = i+1;
            int right = nums.length-1;
            while (left < right){
                if(nums[left] + nums[right] == newTarget){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    list.add(nums[cur]);
                    allList.add(new ArrayList<>(list));
                    while (left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(nums[left] + nums[right] < newTarget){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return allList;
    }

}
