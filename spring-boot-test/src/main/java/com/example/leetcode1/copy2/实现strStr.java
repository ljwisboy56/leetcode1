package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-05 12:09
 */
public class 实现strStr {

    /**
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     */
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
