package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-21 23:15
 */
public class 第80题删除排序数组中的重复项2 {

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int index = 0;
        for (int i = 0; i < nums.length;i++){
            if((i < nums.length -1 ) && nums[i] == nums[i+1]){
                int p1 = i;
                while (p1 <= nums.length-1 && nums[p1] == nums[i]){
                    p1++;
                }
                p1--;
                nums[index] = nums[i];
                nums[index+1] = nums[p1];
                index = index + 2;
                i = p1;
            }else {
                nums[index] = nums[i];
                index++;
            }

        }
        return index;
    }

}
