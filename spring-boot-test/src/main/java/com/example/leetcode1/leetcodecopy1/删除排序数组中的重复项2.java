package com.example.leetcode1.leetcodecopy1;

/**
 * @author yingru.ljw
 * @date 2020-02-09 17:04
 */
public class 删除排序数组中的重复项2 {

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,1,1,1,2,3,3};
        int res = new 删除排序数组中的重复项2().removeDuplicates(arr);
        System.out.println(res);
        }


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
               int end = --p1;
               nums[index] = nums[i];
               nums[index+1] = nums[end];
               index = index + 2;
               i = end;
            }else {
                nums[index] = nums[i];
                index++;
            }

        }

        return index;
    }


}
