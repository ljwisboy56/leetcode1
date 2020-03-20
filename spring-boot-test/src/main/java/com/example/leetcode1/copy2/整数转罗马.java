package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-04 20:05
 */
public class 整数转罗马 {


    public String intToRoman(int num) {
        String[][] chars= {
                {"","I","II","III","IV","V","VI","VII","VIII","IX"},
                {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
                {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
                {"","M","MM","MMM"}
        };

        //个位
        String g = chars[0][num%10];
        String s = chars[1][num/10%10];
        String b = chars[0][num/10/10%10];
        String q = chars[0][num/10/10/10%10];

        return q + b + s + g;
    }

}
