package com.example.leetcode1.copy1;

/**
 * @author yingru.ljw
 * @date 2020-02-02 17:48
 */
public class 实现str函数 {

    public static void main(String[] args) {
        int res = new 实现str函数().strStr("mississippi","issipi");
        System.out.println(res);


    }


    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null){
            return -1;
        }

        if("".equals(needle)){
            return 0;
        }

        if(needle.length() > haystack.length()){
            return -1;
        }
        boolean flag = true;
        for (int i = 0;i < haystack.length();i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                for (int j =1;j < needle.length();j++){
                    if(i+j >= haystack.length() || haystack.charAt(i+j) != needle.charAt(j)){
                        flag = false;
                        break;
                    }else {
                        flag = true;
                    }
                }
                if(flag){
                    return i;
                }
            }
        }
        return -1;
    }
}
