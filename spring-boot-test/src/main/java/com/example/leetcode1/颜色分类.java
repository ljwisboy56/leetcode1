package com.example.leetcode1;

/**
 * @author yingru.ljw
 * @date 2020-01-10 01:27
 */
public class 颜色分类 {

    public void sortColors(int[] nums) {
        int left = 0;

        int right = nums.length-1;

        int cur =0;

        while (cur <= right){
            if(nums[cur] == 0){
                swap(nums,left,cur);
                left++;
                cur++;
            }
            else if (nums[cur] == 2){
                swap(nums,cur,right);
                right--;
            }else {
                cur++;
            }
        }

    }

    private void swap(int[] arr,int a,int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}
