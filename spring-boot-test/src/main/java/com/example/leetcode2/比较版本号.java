package com.example.leetcode2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-17 21:50
 */
public class 比较版本号 {

    public static void main(String[] args) {
        int res = new 比较版本号().compareVersion("1.01","1.001");
        System.out.println(res);


    }

    public int compareVersion(String version1, String version2) {

        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");

        int p1 = 0;
        int p2 = 0;
        while (p1 < nums1.length || p2 < nums2.length){
            String tmp1 = p1 < nums1.length ? nums1[p1] : "0";
            String tmp2 = p2 < nums2.length ? nums2[p1] : "0";

            int res = compare(tmp1,tmp2);

            if(res == 0){
                p1++;
                p2++;
            }else {
                return res;
            }

        }
        return 0;
    }

    private int compare(String num1, String num2) {
        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);
        if (n1 > n2) {
            return 1;
        } else if (n1 < n2) {
            return -1;
        } else {
            return 0;
        }
    }

}
