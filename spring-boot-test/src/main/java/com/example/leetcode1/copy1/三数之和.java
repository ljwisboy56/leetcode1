package com.example.leetcode1.copy1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-01-22 13:35
 */
public class 三数之和 {

    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,1,2,-1,-4};
        new 三数之和().threeSum(arr);
        System.out.println(new 三数之和().allList);


    }


    List<List<Integer>> allList = new ArrayList<>();


    public List<List<Integer>> threeSum(int[] nums) {

        doFind(0, nums);

        return allList;

    }

    private void doFind(int target, int[] nums) {

        //首先排序
        Arrays.sort(nums);

        //获取数组长度
        int len = nums.length;


        for (int i = 0; i < len; i++) {
            int realTarget = target - nums[i];

            //过滤掉重复的
            if (i> 0 && nums[i-1] == nums[i]) {
                continue;
            }

            //左指针
            int left = i + 1;
            //右指针
            int right = len - 1;

            while (left < right) {
                if (nums[left] + nums[right] < realTarget) {
                    left++;
                } else if (nums[left] + nums[right] > realTarget) {
                    right--;
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[right]);
                    list.add(nums[i]);
                    allList.add(new ArrayList<>(list));
                    while (left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
    }
}
