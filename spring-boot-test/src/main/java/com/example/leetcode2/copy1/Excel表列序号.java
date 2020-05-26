package com.example.leetcode2.copy1;

/**
 * @author yingru.ljw
 * @date 2020-02-23 15:15
 */
public class Excel表列序号 {

    public static void main(String[] args) {
        int res = new Excel表列序号().titleToNumber("AB");
        System.out.println(res);
    }


    public int titleToNumber(String s) {
        if(s == null || "".equals(s)){
            return 0;
        }
        int res = 0;
        for (int i = s.length()-1,step = 1; i >=0; step *= 26,i--) {
            res += (s.charAt(i)+1) % 65 * step;
        }
        return res;
    }
}
