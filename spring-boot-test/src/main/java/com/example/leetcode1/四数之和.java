package com.example.leetcode1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-01-01 20:37
 */
public class 四数之和 {

    /**
     * [[-5,-4,-3,1]]
     * @param args
     */
    public static void main(String[] args) {

        int[] nums = new int[]{1,-2,-5,-4,-3,3,3,5};
        List<List<Integer>> res = new 四数之和().fourSum(nums,-11);
        System.out.println(res);
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {

        if(nums == null){
            return res;
        }

        int len = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < len;i++){
//            if(nums[i] > target){
//                break;
//            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int newTraget = target - nums[i];
            int[] newArr = Arrays.copyOfRange(nums,i+1,len);
            threeSum(nums[i],newArr,newTraget);
        }
        return res;
    }



    public List<List<Integer>> threeSum(int pre,int[] nums,int totarget) {
        //求出数组的长度
        int len = nums.length;
        //先排序一把
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
//            if (nums[i] > totarget) {
//                break;
//            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = totarget - nums[i];
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    list.add(pre);
                    res.add(new ArrayList<>(list));
                    while (r > l && nums[l + 1] == nums[l]) {
                        l++;
                    }
                    while (r > l && nums[r - 1] == nums[r]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (nums[l] + nums[r] > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }

}
