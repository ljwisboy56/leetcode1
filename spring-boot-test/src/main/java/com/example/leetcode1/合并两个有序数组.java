package com.example.leetcode1;

/**
 * @author yingru.ljw
 * @date 2020-01-13 23:38
 */
public class 合并两个有序数组 {


    public static void main(String[] args) {

        int[] n1 = new int[]{1,3,4,5,6,7,8,0,0,0,0};
        int[] n2 = new int[]{2,3,4,5};

        new 合并两个有序数组().merge(n1,n1.length,n2,n2.length);


    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] tmp = new int[m + n];

        int l1 = nums1.length-1;

        int l2 = nums2.length-1;

        int cur = n +m -1;

        while (l1 >= 0 && l2 >= 0){
            if(nums1[l1] >= nums2[l2]){
                tmp[cur] = nums1[l1];
                cur--;
                l1--;
            }else if(nums1[l1] < nums2[l2]){
                tmp[cur] = nums2[l2];
                cur--;
                l2--;
            }
        }

        for (int i = 0; i < m +n;i++){
            nums1[i] = tmp[i];
        }

//        if (m + n >= 0) System.arraycopy(tmp, 0, nums1, 0, m + n);

        System.out.println(nums1);

    }

}
