package com.example.leetcode1;

/**
 * @author yingru.ljw
 * @date 2019-12-31 15:46
 */
public class 是否是回文数 {

    public boolean isPalindrome(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        return judge(chars);

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
