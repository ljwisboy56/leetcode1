package com.example.leetcode1;

/**
 * @author yingru.ljw
 * @date 2020-01-05 21:05
 */
public class 外观数列 {

    public static void main(String[] args) {

        String str = new 外观数列().countAndSay(4);
        System.out.println(str);


    }

    public String countAndSay(int n) {

        String pre = "1";

        for (int i = 1;i < n;i++){
            char tmp = pre.charAt(0);
            int count = 1;
            String strTmp = "";
            for(int j = 1;j < pre.length();j++){
                char cc = pre.charAt(j);
                if(tmp == cc){
                 count++;
                }else {
                    count = 1;
                    strTmp += count + String.valueOf(tmp);
                    tmp = cc;
                }
            }
            strTmp += count + String.valueOf(tmp);
            pre = strTmp;

        }
        return pre;

    }
}
