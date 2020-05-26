package com.example.leetcode2.copy1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yingru.ljw
 * @date 2020-02-23 15:04
 */
public class 多数元素 {

    public static void main(String[] args) {
        int res = new 多数元素().majorityElement(new int[]{3,2,3});
        System.out.println(res);

    }


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
