package com.example.leetcode1.copy1;

/**
 * @author yingru.ljw
 * @date 2020-02-08 18:59
 */
public class 颜色分类 {

    public static void main(String[] args) {

        int[] arr = new int[]{2,5,1,10,8};
        new 颜色分类().countSort(arr);
        System.out.println(arr);
    }

    /**
     * 输入: [2,0,2,1,1,0]
     * 输出: [0,0,1,1,2,2]
     * @param nums
     */
    public void sortColors(int[] nums) {
        countSort(nums);
    }

    private void countSort(int[] nums) {
        int min = 1;
        int max = 10;

        int[] arr = new int[max-min +1];

        //先初始化化
        for (int tmp : nums){
            int index = tmp - min;
            arr[index]++;
        }

        int k = 0;
        for (int i =0;i < arr.length;i++){
            while (arr[i] != 0){
                nums[k] = i + min;
                k++;
                arr[i]--;
            }
        }

    }


}
