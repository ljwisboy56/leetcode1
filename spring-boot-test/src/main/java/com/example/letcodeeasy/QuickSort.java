package com.example.letcodeeasy;

import java.util.Arrays;

/**
 * @author yingru.ljw
 * @date 2019-11-19 01:49
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{
                23,24,43,13,11,2,3,4,3
        };

        quickSort(arr,0,arr.length-1);

        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void quickSort(int[] arr, int left, int right) {
        int pivotIndex;
        if(left < right){
            pivotIndex = partion(arr,left,right);
            quickSort(arr,left,pivotIndex-1);
            quickSort(arr,pivotIndex+1,right);
        }

    }

    private static int partion(int[] arr, int left, int right) {
        int pivot = arr[right];

        while (left < right){

            if (left < right && arr[left] <= pivot){
                left++;
            }
            swap(arr,left,right);
            if (left < right && arr[right] >= pivot){
                right--;
            }
            swap(arr,left,right);

        }
        return right;
    }

    private static void swap(int[] L,int i,int j) {

        int temp=L[i];
        L[i]=L[j];
        L[j]=temp;

    }

}
