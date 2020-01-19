package com.example.leetcode1;

/**
 * @author yingru.ljw
 * @date 2020-01-12 20:53
 */
public class 删除排序数组中的重复项2 {

    /**
     * 双指针：一个指向新数组，一个指向当前数组
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        if(nums.length <= 1){
            return nums.length;
        }


        int cunrrent = 1;

        for (int i = 2; i < nums.length;i++){

            if(nums[i] != nums[cunrrent-1]){
                cunrrent++;
                nums[cunrrent] = nums[i];
            }

        }
        return cunrrent+1;
    }

}
