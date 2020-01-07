package com.example.leetcode1;

/**
 * @author yingru.ljw
 * @date 2019-12-30 17:50
 */
public class 最长回文子串 {

//    public static void main(String[] args) {
//        String abc = "abba";
//
//        String res = new 最长回文子串().longestPalindrome(abc);
//
//        System.out.println(res);
//
//    }

    String maxStr = "";

    public String longestPalindrome(String s) {

        if(s == null){
            return null;
        }

        char[] chars = s.toCharArray();

        for(int i = 0; i < chars.length;i++){
            for(int j = i+1;j < chars.length;j++){
                char[] tmp = s.substring(i,j+1).toCharArray();
                if(judge(tmp)){
                    if(s.substring(i,j+1).length() > maxStr.length()){
                        maxStr = s.substring(i,j+1);
                    }
                }
            }

        }
        return maxStr;

    }

    private boolean judge(char[] chars){
        int length = chars.length;

        int start = 0;
        int end = length-1;
        if(length % 2 ==0){
            while (end - start != 1){
                if(chars[start++] == chars[end--]){
                    continue;
                }else {
                    return false;
                }
            }
        }else {
            while (start != end){
                if(chars[start++] == chars[end--]){
                    continue;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

}
