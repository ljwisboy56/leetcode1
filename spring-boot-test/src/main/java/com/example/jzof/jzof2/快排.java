package com.example.jzof.jzof2;

/**
 * @author yingru.ljw
 * @date 2020-01-10 00:24
 */
public class 快排 {

    public static void main(String[] args) {
        int[] arr =new int[]{2,13,23,22,17,17,5};
        int[] res = new 快排().quickSort(arr);
        System.out.println(res);


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
            if(start < end && input[start] <= pivotValue){
                start++;
            }
            swap(input,start,end);
            if(start < end && input[end] >= pivotValue){
                end--;
            }
            swap(input,start,end);
        }
        return end;
    }

    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
