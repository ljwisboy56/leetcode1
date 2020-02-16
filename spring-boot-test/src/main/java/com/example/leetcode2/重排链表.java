package com.example.leetcode2;

import com.example.letcodeeasy.ListNode;
import com.example.排序.快速排序;

import java.util.Arrays;

/**
 * @author yingru.ljw
 * @date 2020-02-16 14:01
 */
public class 重排链表 {

    public static void main(String[] args) {
        int[] arr = new int[]{23,23,24,43,13,11,2,3,4,3};
        new 重排链表().quickSortNums(arr);
        Arrays.stream(arr).forEach(System.out::println);

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
//        l4.next = l5;

        new 重排链表().reorderList(l1);

    }


    public void reorderList(ListNode head) {

        if(head == null){
            return;
        }

        doReorderlist(head);

    }

    private ListNode doReorderlist(ListNode head) {
        if(head == null){
            return null;
        }

        //翻转链表
        head.next = reverse(head.next);

        head = head.next;

        return doReorderlist(head);

    }

    private ListNode reverse(ListNode head){
        ListNode next = null;
        ListNode pre = null;

        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;

    }


    private int[] quickSortNums(int[] nums){

        doQuickSort(nums,0,nums.length-1);

        return nums;
    }

    private void doQuickSort(int[] nums, int start, int end) {

        if(start > end){
            return;
        }

        int pivot = findPivot(nums,start,end);
        doQuickSort(nums,start,pivot-1);
        doQuickSort(nums,pivot+1,end);


    }

    private int findPivot(int[] nums, int start, int end) {

        int pivotValue = nums[end];
        while (start < end){
            if(nums[start] <= pivotValue){
                start++;
            }
            swap(nums,start,end);
            if(start < end && nums[end] >= pivotValue){
                end--;
            }
            swap(nums,start,end);
        }

        return start;

    }

    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
