package com.example.leetcode2.copyleetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-23 11:52
 */
public class 缺失的区间 {

    public static void main(String[] args) {
        int[] nums = new int[]{};
        List<String> res = new 缺失的区间().findMissingRanges(nums,-3,-1);
        System.out.println(res);


    }


    /**
     * nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();

        int left = lower;

        for(int tmp : nums){
            if(left + 1 == tmp){
                res.add(String.valueOf(left));
            }
            if(left +1 < tmp){
                res.add(left + "->" + (tmp - 1));
            }
            left = tmp +1;
        }

        if(left == upper){
            res.add(String.valueOf(left));
        }
        else if(left < upper){
            res.add(left + "->" + upper);

        }

        return res;

    }


}
