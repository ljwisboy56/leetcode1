package com.example.leetcode1.leetcodecopy1;

/**
 * @author yingru.ljw
 * @date 2020-02-03 13:40
 */
public class 最长的有效括号 {

    /**
     * 这题思路，先从左往右找一遍
     * 再从右往左找遍
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {

        int left = 0;

        int right =0;

        int max = 0;


        for (int i =0;i < s.length();i++){
            if(s.charAt(i) == '('){
                left++;
            }
            else if(s.charAt(i) == ')'){
                right++;
            }
            if(left == right){
                max = Math.max(max,right*2);
            }
            if(right > left){
                left=0;
                right=0;
            }
        }

        left = 0;

        right =0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return max;

    }


}
