package com.example.leetcode1.copy2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-22 14:21
 */
public class 第89题格雷编码 {

    public static void main(String[] args) {
        System.out.println(1 << 4);
        System.out.println(Math.pow(2,4));

        List<Integer> res = new 第89题格雷编码().grayCode(4);
        System.out.println(res);
    }

    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < Math.pow(2,n); i++) {
            ret.add(i ^ i >> 1);
        }
        return ret;
    }

}
