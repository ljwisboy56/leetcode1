package com.example.leetcode1.copy1;

/**
 * @author yingru.ljw
 * @date 2020-01-20 00:26
 */
public class 回文数 {

    public static void main(String[] args) {
        boolean res = new 回文数().isPalindrome(1221);
        System.out.println(res);

    }

    public boolean isPalindrome(int x) {

        String[] strings = String.valueOf(x).split("");

        int start = 0;
        int end = strings.length-1;

        while (start < end){
            if(strings[start].equals(strings[end])){
                start++;
                end--;
            }else {
                return false;
            }
        }

        return true;

    }
}
