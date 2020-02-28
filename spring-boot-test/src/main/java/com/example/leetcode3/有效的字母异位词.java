package com.example.leetcode3;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author yingru.ljw
 * @date 2020-02-28 17:43
 */
public class 有效的字母异位词 {


    public boolean isAnagram(String s, String t) {

        char[] a = s.toCharArray();

        char[] b = t.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a,b);

    }

}
