package com.example.leetcode3;

/**
 * @author yingru.ljw
 * @date 2020-02-27 00:20
 */
public class 数组中的第K个最大元素 {

    public static void main(String[] args) {

        int res = new 数组中的第K个最大元素().findKthLargest(new int[]{2,1},2);

        System.out.println(res);
    }


    public int findKthLargest(int[] nums, int k) {

        buildHeap(nums,k);

        for (int i = k; i < nums.length; i++) {
            if(nums[i] < nums[0]){
                continue;
            }
            swap(nums,0,i);
            heapFiy(nums,k,0);
        }
        return nums[0];

    }

    private void buildHeap(int[] nums, int k) {

        for (int i = k/2-1; i >=0 ; i--) {
            heapFiy(nums,k,i);
        }
        
    }

    private void heapFiy(int[] a, int size, int cur) {
        int minPos = cur;
        while (true) {
            //和左子节点比较
            if (cur*2+1 < size && a[cur*2+1] < a[cur]){
                minPos = cur*2+1;
            }
            //和右子节点比较
            if (cur*2+2 < size && a[cur*2+2] < a[minPos]){
                minPos = cur*2+2;
            }
            //如果minPos没有发生变化，说明父节点已经是最小了，直接跳出
            if (minPos == cur){
                break;
            }
            //否则交换
            swap(a, cur, minPos);
            //父节点下标进行更新，继续堆化
            cur = minPos;
        }

    }

    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
