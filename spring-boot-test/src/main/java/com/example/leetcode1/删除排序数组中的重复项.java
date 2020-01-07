package com.example.leetcode1;

/**
 * @author yingru.ljw
 * @date 2020-01-04 20:31
 */
public class 删除排序数组中的重复项 {

    /**
     * 双指针,这题没做出来
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;

        while (j < nums.length){
            if(nums[i] == nums[j]){
                j++;
            }else {
                nums[++i] = nums[j++];
            }
        }
        return i+1;
    }

}
