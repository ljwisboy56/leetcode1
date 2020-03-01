package com.example.leetcode3;

/**
 * @author yingru.ljw
 * @date 2020-03-01 18:07
 */
public class 第一个错误的版本 {

    public int firstBadVersion(int n) {

        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;


    }

    private boolean isBadVersion(int mid) {
        return true;
    }
}
