package com.example.leetcode1.copy2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-04 18:11
 */
public class 两数之和 {

    public int[] twoSum(int[] nums, int target) {
        int[] res= new int[2];

        if(nums == null || nums.length == 0){
            return res;
        }



        List<Integer> list = new ArrayList<>();
        for (int tmp : nums){
            list.add(tmp);
        }


        //先排序一遍数组
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length-1;
        while (left < right){
            if(nums[left] + nums[right] == target){
                res[0] = list.indexOf(nums[left]);
                list.set(res[0], Integer.MIN_VALUE);
                res[1] = list.indexOf(nums[right]);
                list.set(res[1], Integer.MIN_VALUE);
                break;
            }else if(nums[left] + nums[right] > target){
                right--;
            }else {
                left++;
            }
        }
        return res;

    }

}
