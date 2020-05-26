package com.example.leetcode1.copy1;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2020-02-08 00:32
 */
public class 加一 {

    public static void main(String[] args) {

        int[] res = new 加一().plusOne(new int[]{1,0,0,0,0});
        System.out.println(Arrays.toString(res));

    }

    public int[] plusOne(int[] digits) {

        if(digits == null || digits.length ==0){
            return new int[]{};
        }

        Stack<Integer> stack = new Stack<>();

        boolean flag = true;

        for (int i = digits.length-1;i >=0;i--){
            int tmp = digits[i];
            if(flag){
                //如果需要进位则加1
               tmp++;
            }
            //放到栈里面
            stack.push(tmp % 10);
            //如果需要进位则进位
            if(tmp / 10 == 1 && tmp % 10 == 0){
                flag = true;
            }else {
                flag = false;
            }
        }

        if(flag){
            stack.push(1);
        }

        int[] res = new int[stack.size()];

        int len = stack.size();

        for (int i = 0; i < len;i++){
            res[i] = stack.pop();
        }

        return res;

    }

}
