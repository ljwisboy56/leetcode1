package com.example.leetcode3;

/**
 * @author yingru.ljw
 * @date 2020-02-26 12:34
 */
public class 快乐数 {

    /**
     * 快慢指针
     * @param n
     * @return
     */
    public boolean isHappy(int n) {

        int slow = n;
        int fast = n;

        slow = judege(slow);
        fast = judege(fast);
        fast = judege(fast);

        while (slow != fast){
            slow = judege(slow);
            fast = judege(fast);
            fast = judege(fast);
        }

        return slow == 1;

    }

    private int judege(int n){

        String[] strings = String.valueOf(n).split("");

        int res = 0;
        for (String string : strings) {
            res += (Integer.valueOf(string) * Integer.valueOf(string));
        }
        return res;

    }
}
