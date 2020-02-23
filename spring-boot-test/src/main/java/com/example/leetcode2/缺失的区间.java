package com.example.leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-17 16:29
 */
public class 缺失的区间 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 3, 50, 75};


        List<String> list = new 缺失的区间().findMissingRanges(nums,0,99);
        System.out.println(list);

    }


    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        // 记录左边界指针
        long left = lower;
        for (int num : nums) {
            if (left + 1 == num) {
                res.add(String.valueOf(left));
            } else if (left + 1 < num) {
                res.add(left + "->" + (num - 1));
            }
            left = (long) num + 1;
        }
        // 最后与upper比较
        if(left==upper) {
            res.add(String.valueOf(left));
        }else if(left<upper){
            res.add(left +"->"+ upper);
        }
        return res;
    }

}
