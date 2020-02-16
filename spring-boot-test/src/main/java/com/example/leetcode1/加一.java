package com.example.leetcode1;


/**
 * @author yingru.ljw
 * @date 2020-01-09 00:17
 */
public class 加一 {


    public static void main(String[] args) {
        int[] arr = new int[]{9, 9, 9};
        int[] res = new 加一().plusOne(arr);
        System.out.println(res);
    }

    String res = "";

    public int[] plusOne(int[] digits) {
        if (digits == null) {
            return new int[digits.length];
        }

        int len = digits.length - 1;

        doPlus(len, false, digits);

        String[] resStrs = res.split("");

        int[] resint = new int[resStrs.length];

        for (int i = 0; i < resint.length; i++) {
            resint[i] = Integer.valueOf(resStrs[resint.length - 1 - i]);
        }

        return resint;

    }

    private void doPlus(int len, boolean jinwei, int[] digits) {
        if (len < 0) {
            if (jinwei) {
                res += "1";
            }
            return;
        } else {
            int tmp = digits[len];
            if (jinwei || len == digits.length - 1) {
                tmp++;
                res += String.valueOf(tmp % 10);
                if (tmp / 10 == 1) {
                    jinwei = true;
                } else {
                    jinwei = false;
                }
            } else {
                res += String.valueOf(tmp % 10);
            }

            doPlus(len - 1, jinwei, digits);
        }
    }


}
