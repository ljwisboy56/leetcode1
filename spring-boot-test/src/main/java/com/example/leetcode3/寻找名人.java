package com.example.leetcode3;

/**
 * @author yingru.ljw
 * @date 2020-03-01 18:03
 */
public class 寻找名人 {

    int findCelebrity(int n) {
        int result = 0;
        for (int i = 1; i < n; ++i) {
            if (knows(result, i)) {
                result = i;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (result == i) continue;
            if (knows(result, i) || !knows(i, result)) return -1;
        }
        return result;
    }

    private boolean knows(int result, int i) {
        return true;
    }


}
