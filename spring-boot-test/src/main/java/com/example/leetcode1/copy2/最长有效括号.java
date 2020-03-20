package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-05 14:03
 */
public class 最长有效括号 {


    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int max = 0;

        for(int i =0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                left++;
            }else {
                right++;
            }

            if(left == right){
                max = Math.max(max,2 * right);
            }
            if(right > left){
                left=0;
                right=0;
            }
        }
        left=0;
        right=0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                right++;
            } else {
                left++;
            }
            if (left == right) {
                max = Math.max(max, 2 * left);
            }
            if (left > right) {
                left = right = 0;
            }
        }
        return max;
    }
}
