package com.example.leetcode3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-27 23:05
 */
public class 汇总区间 {

    public static void main(String[] args) {
        int[] arr = new int[]{0,2,3,4,6,8,9};
        List<String> res = new 汇总区间().summaryRanges(arr);
        System.out.println(res);


    }


    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        int left = 0;

        for (int right = 1; right < nums.length; right++) {
            if(nums[right] - nums[right-1] ==1){
                continue;
            }else if(nums[right] - nums[right-1] > 1){
                String str = "";
                if(right - left == 1){
                    str += nums[left];
                }else {
                    str += nums[left]+ "->"+nums[right-1];
                }
                left = right;
                res.add(str);
            }
        }

        String str = "";
        if(left == nums.length-1){
            str += nums[left];
        }
        if(nums.length-1 - left >= 1){
            str += nums[left]+ "->"+nums[nums.length-1];
        }
        res.add(str);

        return res;

    }

}
