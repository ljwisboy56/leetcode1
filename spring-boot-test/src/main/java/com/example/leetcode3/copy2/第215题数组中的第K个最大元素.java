package com.example.leetcode3.copy2;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yingru.ljw
 * @date 2020-03-30 19:49
 */
public class 第215题数组中的第K个最大元素 {

    /**
     * 利用小顶堆的特性（堆顶元素最小），先对前K个数组元素进行"原地"建小顶堆，建完小顶堆后，堆顶的元素最小，正好是这K个元素的第K大元素。
     * 然后遍历剩下的元素 nums[k] ~ nums[len-1]
     *
     * 1、如果比堆顶元素小，跳过
     * 2、如果比堆顶元素大，和堆顶元素交换后重新堆化
     * 建堆 buildHeap 时间复杂度 O(K)，遍历剩下元素并且堆化 时间复杂度(N-K)*O(logK)，总体的时间复杂度 O(NlogK)
     *
     * 作者：yankuangshigo
     * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/java-pai-xu-xiao-ding-dui-shi-xian-by-yankuangshig/
     */
    public int findKthLargest(int[] nums, int k) {
        //构建最小堆
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
        for (int i = k; i >=0 ; i--) {
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
