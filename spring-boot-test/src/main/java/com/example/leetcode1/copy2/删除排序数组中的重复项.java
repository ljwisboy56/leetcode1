package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-05 11:20
 */
public class 删除排序数组中的重复项 {

    public static void main(String[] args) {
        int[] arr = {1,1,2};
        int res = new 删除排序数组中的重复项().removeDuplicates(arr);
        System.out.println(res);


    }

    /**
     * 给定数组 nums = [1,1,2],
     *
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     */
    public int removeDuplicates(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }else {
                nums[left] = nums[i];
                left++;
            }
        }
        return left;

    }


}
