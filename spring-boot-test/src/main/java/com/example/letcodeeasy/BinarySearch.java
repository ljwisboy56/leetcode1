package com.example.letcodeeasy;

/**
 * @author yingru.ljw
 * @date 2019-11-21 02:32
 */
public class BinarySearch {


    public int binarySerach(int[] arr,int target){

        return doBinarySearch(arr,target,0,arr.length-1);


    }

    /**
     * 二分查找递归实现
     * @param arr
     * @param target
     * @param left
     * @param right
     * @return
     */
    private int doBinarySearch(int[] arr, int target, int left, int right) {

        if(arr[left] > target || arr[right] < target || arr == null){
            return -1;
        }

        //找到中周坐标
        int mid = left + ((right-left) >>1);

        if(arr[mid] > target){
            return doBinarySearch(arr,target,left,mid);
        }else if(arr[mid] < target){
            return doBinarySearch(arr,target,mid,right);
        }else {
            return mid;
        }

    }


    /**
     * 迭代实现
     * @param arr
     * @param target
     * @param left
     * @param right
     * @return
     */
    private int doBinarySearch2(int[] arr,int target,int left,int right){
        if(arr[left] > target || arr[right] < target || arr == null){
            return -1;
        }

        int finalIndex = -1;

        while (left < right){
            int mid = left + ((right-left) >>1);
            if(arr[mid] > target){
                right = mid-1;
            }else if(arr[mid] < target){
                left = mid;
            }else {
                finalIndex = mid+1;
            }
        }
        return finalIndex;
    }
}
