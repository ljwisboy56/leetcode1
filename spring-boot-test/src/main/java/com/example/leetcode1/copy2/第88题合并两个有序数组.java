package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-22 14:11
 */
public class 第88题合并两个有序数组 {


    /**
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     *
     * 输出: [1,2,2,3,5,6]
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //先把nmus1的数组存起来
        int[] tmp = new int[m];

        System.arraycopy(nums1, 0, tmp, 0, m);

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
