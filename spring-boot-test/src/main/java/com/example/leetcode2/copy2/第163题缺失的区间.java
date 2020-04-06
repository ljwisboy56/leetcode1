package com.example.leetcode2.copy2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-28 17:34
 */
public class 第163题缺失的区间 {

    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 50, 75};
        List<String> res = new 第163题缺失的区间().findMissingRanges(arr,0,99);
        System.out.println(res);

    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        // 记录左边界指针
        long left = lower;
        for(int i=0;i<nums.length;i++){
            if(left+1==nums[i]){
                res.add(String.valueOf(left));
            }else if(left+1<nums[i]){
                res.add(left +"->"+ (nums[i] - 1));
            }
            left = (long)nums[i]+1;
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
