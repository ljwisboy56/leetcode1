package com.example.leetcode2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yingru.ljw
 * @date 2020-02-18 12:28
 */
public class 多数元素 {

    public static void main(String[] args) {
        int res = new 多数元素().majorityElement(new int[]{3});
        System.out.println(res);



    }


    public int majorityElement(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        int max = nums.length /2;

        int maxValue = 0;

        for (int tmp : nums){
            if(map.get(tmp) == null){
                map.put(tmp,1);
                if(maxValue < 1){
                    maxValue = 1;
                }
            }else {
                Integer value = map.get(tmp);
                value++;
                if(value > max){
                    return tmp;
                }else {
                    map.put(tmp,value);
                }
            }
        }

        return maxValue;

    }


}
