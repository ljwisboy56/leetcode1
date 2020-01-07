package com.example.letcodeeasy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2019-11-12 23:27
 */
public class Test1 {


    public int[] twoSum(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for(int n = i+1;n< nums.length;n++){
                int tmp = nums[n];
                if(nums[i] + nums[n] == target){
                    res.add(i);
                    res.add(n);
                }

            }
        }
        int[] resInt = new int[res.size()];
        int m = 0;
        for(int a:res){
            resInt[m++] = a;
        }
        return resInt;
    }
}
