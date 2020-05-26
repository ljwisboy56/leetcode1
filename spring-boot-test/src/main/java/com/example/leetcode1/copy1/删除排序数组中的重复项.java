package com.example.leetcode1.copy1;

/**
 * @author yingru.ljw
 * @date 2020-02-02 17:27
 */
public class 删除排序数组中的重复项 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,1};
        int res = new 删除排序数组中的重复项().removeDuplicates(arr);
        System.out.println(res);


    }


    public int removeDuplicates(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        int index = 0;
        int cur = 0;

        while (cur < nums.length){
            if(cur > 0){
                if(nums[cur] == nums[cur-1]){
                    cur++;
                    continue;
                }
            }

            nums[index] = nums[cur];
            cur++;
            index++;
        }

        return index;

    }


}
