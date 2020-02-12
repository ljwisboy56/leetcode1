package com.example.letcodeeasy;

import java.util.Arrays;

/**
 * @author yingru.ljw
 * @date 2019-11-19 00:55
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{23,24,43,13,11,2,3,4,3};
        sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void sort(int[] arr){
        mergeSort(arr,0,arr.length-1);
    }

    private static void mergeSort(int[] arr,int L,int R){
        if(L < R){
            int mid = L + ((R-L)>>1);
            mergeSort(arr,L,mid);
            mergeSort(arr,mid+1,R);
            doMerge(arr,L,mid,R);
        }
    }

    private static void doMerge(int[] arr, int L, int mid, int R) {
        int[] tmpArray = new int[R-L +1];
        int i = 0;

        int p1 = L;

        int p2 = mid +1;

        while (p1 <= mid && p2 <= R ){
            int tmp = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
            tmpArray[i++] = tmp;
        }

        while (p1 <= mid){
            tmpArray[i++] = arr[p1++];
        }

        while (p2 <= R){
            tmpArray[i++] = arr[p2++];
        }

        for(i = 0;i < tmpArray.length;i++){
            arr[L +i] = tmpArray[i];
        }

    }

}
