package com.example.leetcode1.leetcodecopy1;

/**
 * @author yingru.ljw
 * @date 2020-01-18 22:04
 */
public class 寻找两个有序数组的中位数 {

    public static void main(String[] args) {

        int[] a1 = new int[]{3};
        int[] a2 = new int[]{-2,-1};

        double res = new 寻找两个有序数组的中位数().findMedianSortedArrays(a1,a2);
        System.out.println(res);

    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {


        int l1 = 0;

        int l2 = 0;

        int cur = 0;

        int[] arr = new int[nums1.length + nums2.length];

        while (l1 < nums1.length && l2 < nums2.length){
            if(nums1[l1] <= nums2[l2]){
                arr[cur]= nums1[l1];
                cur++;
                l1++;
            }else {
                arr[cur]= nums2[l2];
                cur++;
                l2++;
            }
        }

        while (l1 < nums1.length){
            arr[cur]= nums1[l1];
            cur++;
            l1++;
        }

        while (l2 < nums2.length){
            arr[cur]= nums2[l2];
            cur++;
            l2++;
        }

        //1 2 3 4 ,1 2 3 4 5
        if(arr.length % 2 == 0){
            double v1 = arr[(arr.length-1)/2];
            double v2 = arr[(arr.length-1)/2+1];
            return ( v2 + v1)/2;
        }else {
            return arr[(arr.length-1)/2];
        }

    }


}
