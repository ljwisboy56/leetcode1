package com.example.leetcode1.copy2;

import java.util.HashMap;

/**
 * @author yingru.ljw
 * @date 2020-03-04 19:04
 */
public class 字符串转换整数 {

    public static void main(String[] args) {

        String str = "-91283472332";

        int res = new 字符串转换整数().myAtoi(str);

        System.out.println(res);

    }


    static HashMap<Character,Integer> map = null;

    static {
        map = new HashMap<>();
        map.put('0',0);
        map.put('1',1);
        map.put('2',2);
        map.put('3',3);
        map.put('4',4);
        map.put('5',5);
        map.put('6',6);
        map.put('7',7);
        map.put('8',8);
        map.put('9',9);
        map.put('-',10);
    }
    public int myAtoi(String str) {

        StringBuilder stringBuilder = null;
        str = str.trim();

        for (int i = 0; i < str.length(); i++) {
            if(map.containsKey(str.charAt(i))){
                stringBuilder = new StringBuilder();
                while (i < str.length()){
                    if(map.containsKey(str.charAt(i))){
                        stringBuilder.append(str.charAt(i));
                        i++;
                    }else {
                        break;
                    }
                }
            }else {
                break;
            }
        }

        if(stringBuilder == null){
            return 0;
        }

        String sloveStr = stringBuilder.toString();


        int res =Integer.valueOf(sloveStr);
        if(String.valueOf(res).equals(sloveStr)){
            return res;

        }else {
            return Integer.MIN_VALUE;
        }

    }

}
