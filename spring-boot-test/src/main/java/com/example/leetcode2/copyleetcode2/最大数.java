package com.example.leetcode2.copyleetcode2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yingru.ljw
 * @date 2020-02-23 15:58
 */
public class 最大数 {

    public static void main(String[] args) {
        int[] nums = {0,9,8,7,6,5,4,3,2,1};
//        String res = new 最大数().largestNumber(nums);
//        System.out.println(res);

        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(asStrs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        System.out.println(Arrays.toString(asStrs));


    }


    public String largestNumber(int[] nums) {
        // Get input integers as strings.
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // Sort strings according to custom comparator.
        Arrays.sort(asStrs, (a, b) -> (b + a).compareTo(a + b));


        // If, after being sorted, the largest number is `0`, the entire number
        // is zero.
        if (asStrs[0].equals("0")) {
            return "0";
        }

        // Build largest number from sorted array.
        String largestNumberStr = new String();
        for (String numAsStr : asStrs) {
            largestNumberStr += numAsStr;
        }

        return largestNumberStr;
    }


}
