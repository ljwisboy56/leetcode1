package com.example.leetcode1.copy1;

/**
 * @author yingru.ljw
 * @date 2020-02-11 00:50
 */
public class 合并两个有序数组 {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,0,0,0};
        int[] arr2 = new int[]{2,5,6};

        new 合并两个有序数组().merge(arr1,3,arr2,3);

    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //先把nmus1的数组存起来
        int[] tmp = new int[m];

        for (int i = 0 ; i < m; i++) {
            tmp[i] = nums1[i];
        }

        int p1 = 0;
        int p2 = 0;

        int cur = 0;

        while (p1 < tmp.length && p2 < nums2.length){
            if(tmp[p1] <= nums2[p2]){
                nums1[cur] = tmp[p1];
                p1++;
            }else {
                nums1[cur] = nums2[p2];
                p2++;
            }
            cur++;
        }

        while (p1 < tmp.length){
            nums1[cur] = tmp[p1];
            cur++;
            p1++;
        }


        while (p2 < nums2.length){
            nums1[cur] = nums2[p2];
            cur++;
            p2++;
        }
    }

}
