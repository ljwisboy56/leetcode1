package com.example.jzof2;

/**
 * @author yingru.ljw
 * @date 2019-12-22 20:17
 */
public class 堆排序 {

    private static void heapSort(int[] arr) {
        //分别取数组的位数来构建最大堆，然后拿出每个数组长度下的最大堆顶元素，存起来就是最大排序
        for(int i = 0; i < arr.length;i++){
            int topIndex = maxHeapfy(arr,arr.length-i);
            swap(arr,topIndex,arr.length-i-1);
        }
    }

    private static int maxHeapfy(int[] arr, int size) {
        for(int i =size-1;i >= 0;i--){
            heapFiy(arr,i,size);
        }
        return 0;

    }

    private static void heapFiy(int[] arr, int cur, int size) {
        int max = cur;
        int leftIndex = 2 * cur +1;
        int rightIndex = 2 * cur +2;

        if(leftIndex < size){
            max =Math.max(arr[max],arr[cur]);
        }

        if(rightIndex < size){
            max =Math.max(arr[max],arr[cur]);
        }

        if(max != cur){
            swap(arr,max,cur);
            heapFiy(arr,max,size);
        }
    }

    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
