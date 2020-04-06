package com.example.leetcode2.copy2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yingru.ljw
 * @date 2020-03-29 01:13
 */
public class 第169题多数元素 {


    public int majorityElement(int[] nums) {
        if(nums == null || nums.length ==0){
            return -1;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int tmp : nums){
            map.put(tmp,map.getOrDefault(tmp,0)+1);
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > nums.length/2){
                return entry.getKey();
            }
        }
        return -1;

    }

}
