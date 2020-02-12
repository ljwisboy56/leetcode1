package com.example.排序;

import java.util.Arrays;

/**
 * @author yingru.ljw
 * @date 2020-02-02 15:25
 */
public class 快速排序 {

    public static void main(String[] args) {
        int[] arr = new int[]{23,23,24,43,13,11,2,3,4,3};
        new 快速排序().quickSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public void quickSort(int[] arr){
        doQuickSort(arr,0,arr.length-1);
    }

    private void doQuickSort(int[] arr,int left, int right) {

        if(left < right){
            int pivotIndex = findPivot(arr,left,right);
            doQuickSort(arr,left,pivotIndex-1);
            doQuickSort(arr,pivotIndex+1,right);
        }

    }

    private int findPivot(int[] arr, int left, int right) {

        //取最后一个值为哨兵值
        int pivotValue = arr[right];

        while (left < right){

            if(arr[left] <= pivotValue){
                left++;
            }
            swap(arr,left,right);
            if(left < right && arr[right] >= pivotValue){
                right--;
            }
            swap(arr,left,right);
        }

        return right;
    }

    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
