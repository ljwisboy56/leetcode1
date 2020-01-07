package com.example.leetcode1;

/**
 * @author yingru.ljw
 * @date 2019-12-30 17:31
 */
public class 寻找两个有序数组的中位数 {

    public static void main(String[] args) {
        int[] n1 = new int[]{1,2,3};
        int[] n2 = new int[]{4,6,7};

        double res = new 寻找两个有序数组的中位数().findMedianSortedArrays(n1,n2);
        System.out.println(res);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int nums1Length = nums1.length;

        int nums2Length = nums2.length;

        int[] tmpArray = new int[nums1Length + nums2Length];


        int p1 = 0;

        int p2 = 0;

        int i = 0;

        while (p1 < nums1Length && p2 < nums2Length){
            int tmp = nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
            tmpArray[i++] = tmp;
        }

        while (p1 < nums1Length){
            tmpArray[i++] = nums1[p1++];
        }

        while (p2 < nums2Length){
            tmpArray[i++] = nums2[p2++];
        }

        int mid = tmpArray.length /2;

        if(tmpArray.length % 2 ==0){
            int pre = tmpArray[mid-1];
            int after = tmpArray[mid];
            return (double) (pre + after) /2;
        }else {

        }

        return (double) tmpArray[mid];


    }

}
