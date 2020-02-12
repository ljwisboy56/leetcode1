package com.example.jzof2;

import java.util.ArrayList;

/**
 * @author yingru.ljw
 * @date 2019-12-29 14:33
 */
public class 找出最小的k个数 {

    ArrayList<Integer> integers = new ArrayList<>();

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        if(input == null || input.length == 0 || k > input.length){
            return integers;
        }

        int[] res = quickSort(input);

        for (int i = 0; i < k;i ++){
            integers.add(res[i]);
        }

        return integers;

    }

    private int[] quickSort(int[] input) {
        if(input == null){
            return null;
        }

        return doQuickSort(0,input.length-1,input);

    }

    private int[] doQuickSort(int start, int end, int[] input) {

        if(start < end){
            int pivotIndex = findPivot(start,end,input);
            doQuickSort(start,pivotIndex-1,input);
            doQuickSort(pivotIndex+1,end,input);
        }

        return input;

    }

    private int findPivot(int start, int end, int[] input) {
        int pivotValue = input[end];

        while (start < end){
            if(input[start] <= pivotValue){
                start++;
                swap(input,start,end);
            }
            if(start < end && input[end] >= pivotValue){
                end--;
                swap(input,start,end);
            }
        }
        return end;
    }

    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
