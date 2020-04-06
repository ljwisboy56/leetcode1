package com.example.leetcode2.copyleetcode2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yingru.ljw
 * @date 2020-02-23 15:58
 */
public class 最大数 {

    public static void main(String[] args) {
        int[] nums = {1,9,8,7,6,5,4,3,2,1};
        String res = new 最大数().largestNumber(nums);
        System.out.println(res);
    }


    public String largestNumber(int[] nums) {
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(asStrs, (a, b) -> (b + a).compareTo(a + b));
        if (asStrs[0].equals("0")) {
            return "0";
        }
        StringBuilder largestNumberStr = new StringBuilder();
        for (String numAsStr : asStrs) {
            largestNumberStr.append(numAsStr);
        }

        return largestNumberStr.toString();
    }


}
