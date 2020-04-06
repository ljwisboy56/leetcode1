package com.example.leetcode2.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-29 01:26
 */
public class 第171题Excel表列序号 {

    public static void main(String[] args) {
        System.out.println(new 第171题Excel表列序号().titleToNumber("AB"));


    }

    public int titleToNumber(String s) {
        if(s == null || "".equals(s)){
            return 0;
        }

        int res = 0;
        for (int i = s.length()-1,step = 1; i >= 0; i--,step *= 26) {
            res += ((s.charAt(i)+1) - 'A') * step;
        }
        return res;
    }

}
