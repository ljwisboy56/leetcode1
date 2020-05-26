package com.example.leetcode1.copy1;

import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2020-02-08 00:49
 */
public class 二进制求和 {

    public static void main(String[] args) {

        String res = new 二进制求和().addBinary("100","110010");
        System.out.println(res);


    }


    public String addBinary(String a, String b) {
        if(a == null || b == null){
            return "";
        }

        String[] sa = a.split("");

        String[] sb = b.split("");

        int[] arr = new int[sa.length];
        for (int i = 0; i < sa.length; i++) {
            arr[i] = Integer.valueOf(sa[i]);
        }


        int[] brr = new int[sb.length];
        for (int i = 0; i < sb.length; i++) {
            brr[i] = Integer.valueOf(sb[i]);
        }

        int p1 = arr.length-1;
        int p2 = brr.length-1;

        Stack<Integer> stack = new Stack<>();

        boolean flag = false;
        while (p1 >= 0 && p2 >= 0){
            int tmp = arr[p1] + brr[p2];
            if(flag){
                ++tmp;
            }
            stack.push(tmp % 2);
            if(tmp / 2 == 1 ){
                flag = true;
            }else {
                flag = false;
            }
            p1--;
            p2--;
        }

        while (p1 >= 0){
            int tmp = arr[p1];
            if(flag){
                ++tmp;
            }
            stack.push(tmp % 2);
            if(tmp / 2 == 1){
                flag = true;
            }else {
                flag = false;
            }
            p1--;
        }

        while (p2 >= 0){
            int tmp = brr[p2];
            if(flag){
                ++tmp;
            }
            stack.push(tmp % 2);
            if(tmp / 2 == 1){
                flag = true;
            }else {
                flag = false;
            }
            p2--;
        }

        if(flag){
            stack.push(1);
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();

    }

}
