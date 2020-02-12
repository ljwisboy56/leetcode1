package com.example.排序;

import java.util.Arrays;

/**
 * @author yingru.ljw
 * @date 2020-02-02 15:24
 */
public class 归并排序 {

    public static void main(String[] args) {
        int[] arr = new int[]{23,23,24,43,13,11,2,3,4,3};
        new 归并排序().mergeSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public void mergeSort(int[] arr){

        this.doMergeSort(arr,0,arr.length-1);

    }

    private void doMergeSort(int[] arr, int left, int right) {

        if(left < right){
            int mid = (left + right) /2 ;
            doMergeSort(arr,left,mid);
            doMergeSort(arr,mid+1,right);
            doMerge(arr,left,mid,right);
        }

    }

    private void doMerge(int[] arr, int left, int mid, int right) {

        int[] res = new int[right-left+1];

        int index = 0;

        int p1 = left;

        int p2 = mid+1;

        while (p1 <= mid && p2 <= right){
            if(arr[p1] <= arr[p2]){
                res[index] = arr[p1];
                index++;
                p1++;
            }else {
                res[index] = arr[p2];
                index++;
                p2++;
            }
        }

        while (p1 <= mid){
            res[index] = arr[p1];
            index++;
            p1++;
        }

        while (p2 <= right){
            res[index] = arr[p2];
            index++;
            p2++;
        }

        for (int i=0;i < res.length ; i++){
            arr[left+i] = res[i];
        }

    }
}
