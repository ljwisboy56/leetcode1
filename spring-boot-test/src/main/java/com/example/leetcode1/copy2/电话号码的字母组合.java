package com.example.leetcode1.copy2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-04 23:06
 */
public class 电话号码的字母组合 {

    public static void main(String[] args) {

        List<String> res = new 电话号码的字母组合().letterCombinations("23");
        System.out.println(res);

    }

    private static HashMap<Character, String> hashMap;

    static {
        hashMap = new HashMap<>();
        hashMap.put('2', "abc");
        hashMap.put('3', "def");
        hashMap.put('4', "ghi");
        hashMap.put('5', "jkl");
        hashMap.put('6', "mno");
        hashMap.put('7', "pqrs");
        hashMap.put('8', "tuv");
        hashMap.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || "".equals(digits)) {
            return res;
        }
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            res = help(res, digits.charAt(i));
        }
        return res;
    }

    private List<String> help(List<String> res, char charAt) {
        List<String> result = new ArrayList<>();
        for (String tmp : res) {
            char[] chars = hashMap.get(charAt).toCharArray();
            for (char aChar : chars) {
                result.add(tmp + aChar);
            }
        }
        return result;
    }

}
