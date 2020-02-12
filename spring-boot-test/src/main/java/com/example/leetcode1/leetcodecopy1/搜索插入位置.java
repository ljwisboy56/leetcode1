package com.example.leetcode1.leetcodecopy1;

/**
 * @author yingru.ljw
 * @date 2020-02-03 19:23
 */
public class 搜索插入位置 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,6};
        int res= new 搜索插入位置().searchInsert(arr,2);
        System.out.println(res);

    }

    public int searchInsert(int[] nums, int target) {

        for (int i=0;i <nums.length;i++){
            if(nums[0] >= target){
                return 0;
            }
            if(i >0 && nums[i] >= target ){
                return i;
            }
        }
        return nums.length;

    }
}
