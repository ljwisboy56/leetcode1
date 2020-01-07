package com.example.leetcode1;

import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2020-01-04 23:34
 */
public class 最长有效括号 {

    public static void main(String[] args) {
        int res = new 最长有效括号().longestValidParentheses("()()()))");
        System.out.println(res);

    }

    public int longestValidParentheses(String s){

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

    public int longestValidParentheses2(String s) {

        if(s == null || "".equals(s)){
            return 0;
        }

        int left = 0;
        int right = s.length()-1;
        while (left < right){
            boolean res = true;
            if(s.charAt(left) == ')'){
                left++;
                res = false;
            }

            if(s.charAt(right) == '('){
                left++;
                res = false;
            }

            if(res){
                String str = s.substring(left,right+1);
                if(vaild(str)){
                    return str.length();
                }else {
                    if(vaild(str.substring(0,str.length()-1))){
                        return str.length()-1;
                    }
                    if(vaild(str.substring(1))){
                        return str.length()-1;
                    }
                    left++;
                    right--;
                }

            }
        }
       return 0;
    }

    private boolean vaild(String s){
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < chars.length;i++){
            if(chars[i] == '('){
                stack.push('(');
            }else {
                if(stack.isEmpty()){
                    return false;
                }else {
                    char tmp = stack.pop();
                    if(tmp != '('){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
