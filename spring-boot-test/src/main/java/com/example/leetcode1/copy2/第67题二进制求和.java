package com.example.leetcode1.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-20 00:01
 */
public class 第67题二进制求和 {

    public static void main(String[] args) {
        String res = new 第67题二进制求和().addBinary("1111","1111");
        System.out.println(res);
    }

    public String addBinary(String a, String b) {

        int p1 = a.length()-1;
        int p2 = b.length()-1;

        boolean flag = false;
        StringBuilder stringBuilder = new StringBuilder();
        while (p1 >= 0 && p2 >= 0 ){
            int val = (a.charAt(p1) - '0') + (b.charAt(p2) - '0');
            if(flag){
                val+=1;
            }
            flag = val >= 2;
            val %= 2;
            stringBuilder.append(val);
            p1--;
            p2--;
        }

        while (p1 >= 0){
            int val = a.charAt(p1) - '0';
            if(flag){
                val+=1;
            }
            flag = val >= 2;
            val %= 2;
            stringBuilder.append(val);
            p1--;
        }

        while (p2 >= 0){
            int val =b.charAt(p2) - '0';
            if(flag){
                val+=1;
            }
            flag = val >= 2;
            val %= 2;
            stringBuilder.append(val);
            p2--;
        }

        if(flag){
            stringBuilder.append(1);
        }
        return stringBuilder.reverse().toString();
    }

}
