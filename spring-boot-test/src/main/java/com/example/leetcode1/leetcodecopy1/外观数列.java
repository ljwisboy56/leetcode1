package com.example.leetcode1.leetcodecopy1;

/**
 * @author yingru.ljw
 * @date 2020-02-03 22:32
 */
public class 外观数列 {

    public static void main(String[] args) {
        String res = new 外观数列().countAndSay(6);
//        String res = new 外观数列().parse("111221");
        System.out.println(res);



    }

    public String countAndSay(int n) {

        String str="1";

        //用循环外面控制递归
        for (int i =1;i <n;i++){
            str = parse(str);
        }

        return str;

    }

    /**
     * 1
     * 11
     * 21
     * @param str
     * @return
     */
    private String parse(String str) {
        String res = "";
        char[] chars = str.toCharArray();
        int count = 1;
        for (int i = 0;i < chars.length;i++){
            char tmp = chars[i];
            if(i == chars.length-1){
                return  res += (count + String.valueOf(tmp));
            }
            while (i +1 < chars.length && chars[i]==chars[i+1] ) {
                count++;
                i++;
            }
            res += (count + String.valueOf(tmp));
            count = 1;
        }
        return res;
    }

}
