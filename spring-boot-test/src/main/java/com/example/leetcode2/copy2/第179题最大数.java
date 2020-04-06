package com.example.leetcode2.copy2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author yingru.ljw
 * @date 2020-03-29 14:51
 */
public class 第179题最大数 {

    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return "";
        }

        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
            }
        });

        if("0".equals(strings[0])){
            return "0";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(String str : strings){
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

}
