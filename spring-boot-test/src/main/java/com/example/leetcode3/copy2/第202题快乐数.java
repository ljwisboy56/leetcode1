package com.example.leetcode3.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-30 00:18
 */
public class 第202题快乐数 {

    public boolean isHappy(int n) {
        //慢指针
        int slow = count(n);
        //快指针
        int fast = count(count(n));
        while (slow != fast){
            slow = count(slow);
            fast = count(count(fast));
        }
        return fast == 1;
    }

    private int count(int n) {
        int res = 0;
        String[] strings = String.valueOf(n).split("");
        for (String string : strings) {
            res += (Integer.valueOf(string) * Integer.valueOf(string));
        }
        return res;
    }

}
