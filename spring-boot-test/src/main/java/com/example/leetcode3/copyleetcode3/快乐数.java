package com.example.leetcode3.copyleetcode3;

/**
 * @author yingru.ljw
 * @date 2020-03-02 15:07
 */
public class 快乐数 {

    public static void main(String[] args) {

        System.out.println(new 快乐数().isHappy(2));

    }


    public boolean isHappy(int n) {

        //慢指针
        int slow = count(n);
        //快指针
        int fast = count(count(n));

        while (slow != fast){

            slow = count(slow);
            fast = count(count(fast));
        }

        return slow ==1;
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
