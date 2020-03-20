package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-17 00:07
 */
public class 第26题删除排序数组中的重复项 {

    public static void main(String[] args) {

        int[] arr = {1,1,2};
        int res = new 第26题删除排序数组中的重复项().removeDuplicates(arr);
        System.out.println(res);

    }


    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[index] == nums[i]){
                continue;
            }else {
                index++;
                nums[index] = nums[i];
            }
        }
        return index+1;
    }

}
