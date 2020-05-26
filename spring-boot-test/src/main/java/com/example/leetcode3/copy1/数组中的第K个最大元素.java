package com.example.leetcode3.copy1;

/**
 * @author yingru.ljw
 * @date 2020-03-02 22:09
 */
public class 数组中的第K个最大元素 {


    public int findKthLargest(int[] nums, int k) {
        //构建一个小顶堆
        heap(nums,k);
        for (int i = k; i < nums.length; i++) {
            if(nums[i] < nums[0]){
                continue;
            }
            swap(nums,0,i);
            heapFiy(nums,0,k);
        }
        return nums[0];

    }

    private void heap(int[] nums, int size) {

        for (int i = size/2-1; i >=0 ; i--) {
            heapFiy(nums,i,size);
        }

    }

    private void heapFiy(int[] nums, int cur, int size) {
        int min = cur;
        for(;;){
            if(2 * cur +1< size && nums[2 * cur+1] < nums[cur]){
                min = 2 * cur+1;
            }

            if(2 * cur+2 < size && nums[2 * cur+2] < nums[min]){
                min = 2 * cur+2;
            }

            if(min == cur){
                break;
            }
            //否则交换
            swap(nums, cur, min);
            cur = min;
        }
    }


    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
