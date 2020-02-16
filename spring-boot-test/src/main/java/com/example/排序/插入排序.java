package com.example.排序;

import java.util.Arrays;

/**
 * @author yingru.ljw
 * @date 2020-02-16 17:01
 */
public class 插入排序 {

    public static void main(String[] args) {
        int[] arr = new int[]{23,23,24,43,13,11,2,3,4,3};
        new 插入排序().inserSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }


    private void inserSort(int[] nums){

        //从1开始，假设第0个元素是有序的
        for (int i = 1;i < nums.length;i++){
            //拿到上一个有序元素的尾坐标
            int preIndex = i - 1;
            int cur = nums[i];
            //拿当前值去跟有序数组比，如果大于直接放在上一个数组的尾标后面
            //如果小于那么找，到哪里就不小于了
            while (preIndex >=0 && nums[preIndex] > cur){
                //内部要向后串
                nums[preIndex+1] = nums[preIndex];
                //尾标向前
                preIndex--;
            }
            nums[preIndex+1] = cur;
        }
    }

}
