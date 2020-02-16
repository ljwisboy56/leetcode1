package com.example.leetcode1;


/**
 * @author yingru.ljw
 * @date 2020-01-09 00:44
 */
public class 二进制求和 {

    public static void main(String[] args) {

        String res = new 二进制求和().addBinary("1010", "1011");
        System.out.println(res);


    }

    public String addBinary(String a, String b) {
        if (a == null) {
            return b;
        }

        if (b == null) {
            return a;
        }

        String[] sa = a.split("");
        String[] sb = b.split("");

        Integer[] ai = new Integer[a.length()];
        Integer[] bi = new Integer[b.length()];

        for (int i = 0; i < a.length(); i++) {
            ai[i] = Integer.valueOf(sa[i]);
        }

        for (int i = 0; i < b.length(); i++) {
            bi[i] = Integer.valueOf(sb[i]);
        }

        String res = "";

        int a1 = ai.length;
        int b1 = bi.length;
        boolean flag = false;
        while (a1 != 0 && b1 != 0) {
            a1--;
            b1--;
            if (!flag) {
                int tmp = ai[a1] + bi[b1];
                if(tmp == 2){
                    flag = true;
                    tmp = 0;
                }
                res += String.valueOf(tmp);
            } else {
                int tmp = ai[a1] + bi[b1] + 1;
                if(tmp == 2){
                    flag = true;
                    tmp = 0;
                }
                if(tmp == 3){
                    flag = true;
                    tmp = 1;
                }else {
                    flag = false;
                }
                res += String.valueOf(tmp);
            }

        }

        while (a1 != 0) {
            if (flag) {
                int tmp = ai[a1] + 1;
                if(tmp == 2){
                    flag = true;
                    tmp = 0;
                }
                if(tmp == 3){
                    flag = true;
                    tmp = 1;
                }
                res += String.valueOf(tmp);
            } else {
                int tmp = ai[a1];
                res += String.valueOf(tmp);
            }
            a1--;
        }

        while (b1 != 0) {
            if (flag) {
                int tmp = bi[b1] + 1;
                if(tmp == 2){
                    flag = true;
                    tmp = 0;
                }
                if(tmp == 3){
                    flag = true;
                    tmp = 1;
                }
                res += String.valueOf(tmp);
            } else {
                int tmp = bi[a1];
                res += String.valueOf(tmp);
            }
            b1--;
        }

        if (flag) {
            res += "1";
        }

        String fs = "";
        for (int i = res.length() - 1; i >= 0; i--) {
            fs += res.charAt(i);
        }
        return fs;
    }
}
